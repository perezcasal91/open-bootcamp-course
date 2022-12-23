package functional_prog;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAndLambdaMain {
    public static void main(String[] args) {
        Integer [] aiIds = {1, 2};
        EmployeeDB cEmployeeDB = new EmployeeDB();
        createStream().forEach(System.out::println);
        streamForEach(cEmployeeDB);
        streamForEachSetPropertyUsingLambda(cEmployeeDB);
        streamMapFindByIds(aiIds, cEmployeeDB);
        streamCollect(cEmployeeDB);
        streamFilerMapFindByIds(aiIds, cEmployeeDB);
        streamFilerMapFindByIdsFindFirst(aiIds, cEmployeeDB);
        streamToArray(cEmployeeDB);
        streamFlatMap();
        streamPeek(cEmployeeDB, 50d);
        streamPeek(cEmployeeDB, 500d);
        streamCount(cEmployeeDB);
        streamIterateSkipLimit();
        streamSortedCompareByName(cEmployeeDB);
        streamSimpleMinById(cEmployeeDB);
        streamMaxUsingComparatorBySalary(cEmployeeDB);
        streamComparatorNaturalAndReverseOrder();
        streamDistinct();
        streamAllMatchAnyNone();
        streamMaxValue(cEmployeeDB);
        streamCreation();
        streamAverageAndSum(cEmployeeDB);
        streamReduce(cEmployeeDB);
        streamJoin(cEmployeeDB);
        streamToSet();
        streamToVectorCollection(cEmployeeDB);
        streamSummarizingDouble(cEmployeeDB);
        streamSummarizingDoubleUsingMap(cEmployeeDB);
        streamPartitionBy();
        streamPartitionBy(cEmployeeDB);
        streamGroupBy();
        streamGroupBy(cEmployeeDB);
        streamMapping(cEmployeeDB);
        streamReducing(cEmployeeDB);
        streamReducingAndGroupBy(cEmployeeDB);
        streamGenerateAndIterate();
        streamWriteFile();
        streamWriteFileEmployee(cEmployeeDB);
        streamWriteFileEmployeeJson(cEmployeeDB);
        streamReadFile();
        streamReadFileEmployee();
        streamTakeWhile();
        streamDropWhile();
    }
    private static final Employee[] aEmployees =
       {
               new Employee(1, "Kyle", 10000d),
               new Employee(2, "Ros", 20000d),
               new Employee(3, "Kle", 30000d)
       };
    private static Stream<Employee> createStream (){
        return Stream.of(aEmployees);
    }
    private static void streamForEach(EmployeeDB employeeDB){
        employeeDB.getEmployees().forEach(System.out::println);
    }
    private static void streamForEachSetPropertyUsingLambda(EmployeeDB employeeDB) {
        employeeDB.getEmployees().forEach((employee) -> {
            employee.setSalary(50d);
            System.out.println(employee);
        });
    }
    private static void streamMapFindByIds(Integer [] employeeIds, EmployeeDB employeeDB) {
        Stream.of(employeeIds)
                .map(employeeDB::findById)
                .toList()
                .forEach(System.out::println);
    }
    private static void streamCollect(EmployeeDB employeeDB) {
        employeeDB.getEmployees().stream()
                .toList()
                .forEach(System.out::println);
    }
    private static void streamFilerMapFindByIds(Integer [] employeeIds, EmployeeDB employeeDB) {
        Stream.of(employeeIds)
                .map(employeeDB::findById)
                .filter(Objects::nonNull)
                .filter(employee -> employee.getSalary() < 20000d)
                .toList()
                .forEach(System.out::println);
    }
    private static void streamFilerMapFindByIdsFindFirst(Integer [] employeeIds, EmployeeDB employeeDB) {
        System.out.println(Stream.of(employeeIds)
                .map(employeeDB::findById)
                .filter(Objects::nonNull)
                .filter(employee -> employee.getSalary() < 20000d)
                .findFirst()
                .orElse(null));
    }
    private static void streamToArray(EmployeeDB employeeDB) {
        var vaEmployees = employeeDB.getEmployees().toArray(Employee[]::new);
        for (Employee employee : vaEmployees) {
            System.out.println(employee);
        }
    }
    private static void streamFlatMap() {
        var llsEmployeeNames = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "F"));
        var lsFlatMapNames = llsEmployeeNames.stream()
                .flatMap(Collection::stream)
                .toList();
        lsFlatMapNames.forEach(System.out::println);

    }
    private static void streamPeek(EmployeeDB employeeDB, double salary) {
        employeeDB.getEmployees().stream()
                .peek(employee -> employee.setSalary(salary))
                .toList()
                .forEach(System.out::println);
    }
    private static void streamCount(EmployeeDB employeeDB) {
        System.out.println(employeeDB.getEmployees().stream()
                .filter(employee -> employee.getSalary() > 50d)
                .count());
    }
    private static void streamIterateSkipLimit() {
        var vsiInfinite = Stream.iterate(2, i -> i * 3);
        vsiInfinite.skip(1)
                .limit(5)
                .toList()
                .forEach(System.out::println);
    }
    private static void streamSortedCompareByName(EmployeeDB employeeDB) {
        employeeDB.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList()
                .forEach(System.out::println);
    }
    private static void streamSimpleMinById(EmployeeDB employeeDB) {
        System.out.println(employeeDB.getEmployees().stream()
                .min(Comparator.comparingInt(Employee::getId))
                .orElseThrow(NoSuchElementException::new));
    }
    private static void streamMaxUsingComparatorBySalary(EmployeeDB employeeDB) {
        System.out.println(employeeDB.getEmployees().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new));
    }
    private static void streamComparatorNaturalAndReverseOrder() {
        var vliNumbers = Arrays.asList(1,2,5,2,7,3,5);
        vliNumbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println();
        vliNumbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }
    private static void streamDistinct(){
        var vliNumbers = Arrays.asList(1,2,5,2,7,3,5);
        vliNumbers.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);
    }
    private static void streamAllMatchAnyNone() {
        var vliNumbers = Arrays.asList(1,2,5,2,7,3,5);
        var vbAllEven = vliNumbers.stream().allMatch(integer -> integer % 2 == 0);
        var vbAnyEven = vliNumbers.stream().anyMatch(integer -> integer % 2 == 0);
        var vbNoneMultipleOfThree = vliNumbers.stream().noneMatch(integer -> integer % 3 == 0);
        System.out.println(vbAllEven + " " + vbAnyEven + " " + vbNoneMultipleOfThree);
    }
    private static void streamMaxValue(EmployeeDB employeeDB) {
        var voiLatestEmployeeId = employeeDB.getEmployees().stream()
                .mapToInt(Employee::getId).max();
        voiLatestEmployeeId.ifPresent(i -> System.out.println(voiLatestEmployeeId.getAsInt()));
    }
    private static void streamCreation(){
        var visIntegers = IntStream.of(1, 2, 3, 4, 5);
        visIntegers.forEach(System.out::print);
        System.out.println();
        var visRangeIntegers = IntStream.range(1, 4);
        visRangeIntegers.forEach(System.out::print);
        System.out.println();
        var vsiIntegers = Stream.of(1, 2, 3, 4, 5, 6, 7);
        vsiIntegers.forEach(System.out::print);
    }

    private static void streamAverageAndSum(EmployeeDB employeeDB) {
        var vdAverage = employeeDB.getEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(vdAverage);
        var vdSum = employeeDB.getEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(vdSum);
    }
    private static void streamReduce(EmployeeDB employeeDB) {
        var vdReduce = employeeDB.getEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0d, Double::sum);
        System.out.println(vdReduce);
    }
    private static void streamJoin(EmployeeDB employeeDB) {
        var vsJoin = employeeDB.getEmployees().stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(vsJoin);
    }
    private static void streamToSet() {
        var vliNumbers = Arrays.asList(1,2,5,2,7,3,5);
        var vhsNumbers = new HashSet<>(vliNumbers);
        vhsNumbers.forEach(System.out::println);
    }
    private static void streamToVectorCollection(EmployeeDB employeeDB) {
        var vvsStrings = employeeDB.getEmployees().stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));
        vvsStrings.forEach(System.out::println);
    }
    private static void streamSummarizingDouble(EmployeeDB employeeDB) {
        var vdssStatistics = employeeDB.getEmployees().stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Sum: " + vdssStatistics.getSum());
        System.out.println("Average: " + vdssStatistics.getAverage());
        System.out.println("Min: " + vdssStatistics.getMin());
        System.out.println("Max: " + vdssStatistics.getMax());
        System.out.println("Count: " + vdssStatistics.getCount());
    }
    private static void streamSummarizingDoubleUsingMap(EmployeeDB employeeDB) {
        var vdssStatistics = employeeDB.getEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Sum: " + vdssStatistics.getSum());
        System.out.println("Average: " + vdssStatistics.getAverage());
        System.out.println("Min: " + vdssStatistics.getMin());
        System.out.println("Max: " + vdssStatistics.getMax());
        System.out.println("Count: " + vdssStatistics.getCount());
    }
    private static void streamPartitionBy() {
        var vliIntegers = Arrays.asList(2, 4, 5, 6, 8);
        var vmbliIsEven = vliIntegers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(vmbliIsEven.size());
        vmbliIsEven.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamPartitionBy(EmployeeDB employeeDB) {
        var vmbleSalary = employeeDB.getEmployees().stream()
                .collect(Collectors.partitioningBy(employee -> employee.getName().equals("Kyle")));
        System.out.println(vmbleSalary.size());
        vmbleSalary.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGroupBy() {
        var vliNumbers = Arrays.asList(2, 4, 5, 6, 8);
        var vmbliIsEven = vliNumbers.stream()
                .collect(Collectors.groupingBy(i -> i % 2 == 0));
        System.out.println(vmbliIsEven.size());
        vmbliIsEven.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGroupBy(EmployeeDB employeeDB) {
        var vmcleGroupByCharacter = employeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)));
        System.out.println(vmcleGroupByCharacter.size());
        vmcleGroupByCharacter.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamMapping(EmployeeDB employeeDB) {
        var vmcliMapping = employeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)
                        ,Collectors.mapping(Employee::getId, Collectors.toList())));
        vmcliMapping.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamReducing(EmployeeDB employeeDB) {
        var vdPercentage = 10D;
        var vdReducing = employeeDB.getEmployees().stream()
                .map(employee -> employee.getSalary() * vdPercentage / 100)
                .reduce(0d, Double::sum);
        System.out.println(vdReducing);
    }
    private static void streamReducingAndGroupBy(EmployeeDB employeeDB) {
        var vceNamesComparator = Comparator.comparing(Employee::getName);
        var vmcoeGroupEmployeeByMaxNameLength = employeeDB.getEmployees().stream().
                collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)
                        ,Collectors.reducing(BinaryOperator.maxBy(vceNamesComparator))));
        vmcoeGroupEmployeeByMaxNameLength.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGenerateAndIterate() {
        var vsdGenerateNumberList = Stream.generate(Math::random).limit(5);
        vsdGenerateNumberList.forEach(System.out::println);
        System.out.println();
        var vsiInfiniteIterator = Stream.iterate(1, i-> i <= 5, i-> i + 1);
        var vliNumbers = vsiInfiniteIterator.toList();
        vliNumbers.forEach(System.out::println);
    }
    private static void streamWriteFile() {
        String [] asWords = {
                "hello",
                "refer",
                "world",
                "level"
        };
        try {
            var vpUri = Paths.get("src/resources/doc/stream_file.txt");
            var vpwPrint = new PrintWriter(Files.newBufferedWriter(vpUri));
            Stream.of(asWords).forEach(vpwPrint::println);
            vpwPrint.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamWriteFileEmployee(EmployeeDB employeeDB) {
        try {
            var vpUri = Paths.get("src/resources/doc/stream_file_employee.txt");
            var vpwPrint = new PrintWriter(Files.newBufferedWriter(vpUri));
            Stream.of(employeeDB.getEmployees().toArray()).forEach(vpwPrint::println);
            vpwPrint.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamWriteFileEmployeeJson(EmployeeDB employeeDB) {
        try {
            var vpUri = Paths.get("src/resources/json/stream_file_employee.json");
            var vpwPrint = new PrintWriter(Files.newBufferedWriter(vpUri));
            vpwPrint.print("{");
            Stream.of(employeeDB.getEmployees().stream().map(Employee::toJSON).toArray())
                    .forEach(o -> {
                        vpwPrint.println(o);
                        if (!employeeDB.getEmployees().get(employeeDB.getEmployees().size() - 1).toJSON().equals(o)) {
                            vpwPrint.print(",");
                        }
                    });
            vpwPrint.print("}");
            vpwPrint.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamReadFile() {
        try {
            var vpUri = Paths.get("src/resources/doc/stream_file.txt");
            var vlsWords = Stream.of(Files.readString(vpUri)).toList();
            vlsWords.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamReadFileEmployee() {
      var employeeList = new ArrayList<>();
        try {
            var vpUri = Paths.get("src/resources/doc/stream_file_employee.txt");
            var vlsStringEmployees = Stream.of(Files.readString(vpUri)).toList();
            vlsStringEmployees.forEach(s -> {
                var vlsData = Arrays.stream(s.substring(9, s.length() - 1).split(",")).toList();
                var viId = Integer.parseInt(vlsData.get(0).split("=")[1]);
                var vsName = vlsData.get(1).split("=")[1];
                var vdSalary = Double.parseDouble(vlsData.get(2).split("=")[1]);
                employeeList.add(new Employee(viId, vsName, vdSalary));
            });
            employeeList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamTakeWhile() {
        var vsiNumbers = Stream.of(1, 2, 1, 4, 2, 6);
        vsiNumbers.takeWhile(n -> n < 3).forEach(System.out::println);
    }
    private static void streamDropWhile() {
        var vsiNumbers = Stream.of(1, 2, 1, 4, 2, 6);
        vsiNumbers.dropWhile(n -> n < 3).forEach(System.out::println);
    }
}
 class EmployeeDB {
    private List<Employee> employees;
    public EmployeeDB(){
        initEmployeeList();
    }
     private void initEmployeeList() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Kyle", 10000d));
        employees.add(new Employee(2, "Ros", 20000d));
        employees.add(new Employee(3, "Kle", 30000d));
    }
    public Employee findById(Integer id) {
        return employees.stream().filter(employee ->
                Objects.equals(employee.getId(), id))
                .findFirst()
                .orElse(null);
    }
     public List<Employee> getEmployees() {return employees;}
 }
class Employee {
    private final Integer id;
    private final String name;
    private Double salary;
    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Double getSalary() {
        return this.salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                " id=" + this.getId() +
                ", name=" + this.getName() +
                ", salary=" + this.getSalary() +
                '}';
    }
    public String toJSON() {
        return "\n  \"employee" + this.getId() + "\":" +
                "\n  {" +
                "\n    \"id\":" + this.getId() +
                ",\n    \"name\":" + "\"" + this.getName() + "\"" +
                ",\n    \"salary\":" + this.getSalary() +
                "\n  }";
    }
}