package com.perezcasal.designpatterns.patterns.structural.proxy;

import java.util.HashMap;

public class YouTubeIntegrationMain {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("cats");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dog");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("cats");
        downloader.renderVideoPage("bunnies");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}

interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}

class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    private int random() {
        return 5 + (int) (Math.random() + ((10 - 5) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random();
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading populars... ");

        experienceNetworkLatency();

        var populars = new HashMap<String, Video>();
        populars.put("cats", new Video("cat", "cat.avi"));
        populars.put("pets", new Video("pet", "pet.avi"));
        populars.put("dogs", new Video("dog", "dog.avi"));
        populars.put("bunnies", new Video("bunny", "bunny.avi"));

        System.out.print("Done!" + "\n");
        return populars;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();

        Video video = new Video(videoId, "Cars");

        System.out.print("Done!" + "\n");
        return video;
    }
}

record Video(String id, String title) {
    public static String data() {
        return "This is a Video";
    }
}

class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private final ThirdPartyYouTubeLib youTubeLibService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private final HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youTubeLibService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youTubeLibService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeLibService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }
}

class YouTubeDownloader {
    private final ThirdPartyYouTubeLib youTubeLibService;

    public YouTubeDownloader(ThirdPartyYouTubeLib youTubeLibService) {
        this.youTubeLibService = youTubeLibService;
    }

    public void renderVideoPage(String videoId) {
        Video video = youTubeLibService.getVideo(videoId);

        System.out.println("\n--------------------------");
        System.out.println("Video Page");
        System.out.println("Id: " + video.id());
        System.out.println("Title: " + video.title());
        System.out.println("Data: " + Video.data());
        System.out.println("--------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = youTubeLibService.popularVideos();

        System.out.println("\n--------------------------");
        System.out.println("Most popular videos on YouTube");
        for (Video video : list.values()) {
            System.out.println("Id: " + video.id() + " / Title: " + video.title() + "/ Data: " + Video.data());
        }
        System.out.println("--------------------------\n");
    }
}