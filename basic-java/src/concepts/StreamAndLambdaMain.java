package concepts;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        Integer [] employeeIds = {1, 2};
        EmployeeDB employeeDB = new EmployeeDB();
//        streamForEach(employeeDB);
//        streamForEachSetPropertyUsingLambda(employeeDB);
//        streamMapFindByIds(employeeIds, employeeDB);
//        streamCollect(employeeDB);
//        streamFilerMapFindByIds(employeeIds, employeeDB);
//        streamFilerMapFindByIdsFindFirst(employeeIds, employeeDB);
//        streamToArray(employeeDB);
//        streamFlatMap();
//        streamPeek(employeeDB, 50d);
//        streamPeek(employeeDB, 500d);
//        streamCount(employeeDB);
//        streamIterateSkipLimit();
//        streamSortedCompareByName(employeeDB);
//        streamSimpleMin(employeeDB);
//        streamMaxUsingComparatorBySalary(employeeDB);
//        streamComparatorNaturalAndReverseOrder();
//        streamDistinct();
//        streamAllMatchAnyNone();
//        streamMaxValue(employeeDB);
//        streamCreation();
//        streamAverageAndSum(employeeDB);
//        streamReduce(employeeDB);
//        streamJoin(employeeDB);
//        streamToSet();
//        streamToVectorCollection(employeeDB);
//        streamSummarizingDouble(employeeDB);
//        streamSummarizingDoubleUsingMap(employeeDB);
//        streamPartitionBy(employeeDB);
//        streamGroupBy(employeeDB);
//        streamMapping(employeeDB);
//        streamReducing(employeeDB);
//        streamReducingAndGroupBy(employeeDB);
//        streamGenerateAndIterate();
//        streamWriteFile();
//        streamWriteFileEmployee(employeeDB);
//        streamReadFile();
//        streamReadFileEmployee();
//        streamTakeWhile();
        streamDropWhile();
    }
    private static final Employee[] listEmployees =
       {
       new Employee(1, "Kyle", 10000d),
       new Employee(2, "Ros", 20000d),
       new Employee(3, "Kle", 30000d)
       };
    private static Stream<Employee> createStream (){
        return Stream.of(listEmployees);
    }
    private static void streamForEach(EmployeeDB employeeDB){
        employeeDB.employeeList.forEach(System.out::println);
    }
    private static void streamForEachSetPropertyUsingLambda(EmployeeDB employeeDB){
        employeeDB.employeeList.forEach((employee)-> {
            employee.setSalary(50d);
            System.out.println(employee);
        });
    }
    private static void streamMapFindByIds(Integer [] employeeIds, EmployeeDB employeeDB){
        Stream.of(employeeIds).map(employeeDB::findById).toList().forEach(System.out::println);
    }
    private static void streamCollect(EmployeeDB employeeDB){
        employeeDB.employeeList.stream().toList().forEach(System.out::println);
    }

    private static void streamFilerMapFindByIds(Integer [] employeeIds, EmployeeDB employeeDB){
        Stream.of(employeeIds).map(employeeDB::findById).filter(Objects::nonNull)
                .filter(employee -> employee.getSalary() < 20000d).toList().forEach(System.out::println);
    }
    private static void streamFilerMapFindByIdsFindFirst(Integer [] employeeIds, EmployeeDB employeeDB){
        System.out.println(Stream.of(employeeIds).map(employeeDB::findById).filter(Objects::nonNull)
                .filter(employee -> employee.getSalary() < 20000d).findFirst().orElse(null));
    }
    private static void streamToArray(EmployeeDB employeeDB){
        var employees = employeeDB.employeeList.toArray(Employee[]::new);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    private static void streamFlatMap(){
        var employeeNames = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "F"));
        var flatMapNames = employeeNames.stream().flatMap(Collection::stream).toList();
        flatMapNames.forEach(System.out::println);

    }
    private static void streamPeek(EmployeeDB employeeDB, double salary){
        employeeDB.employeeList.stream().peek(employee -> employee.setSalary(salary))
                .toList().forEach(System.out::println);
    }
    private static void streamCount(EmployeeDB employeeDB){
        System.out.println(employeeDB.employeeList.stream().filter(employee -> employee.getSalary() > 50d).count());
    }
    private static void streamIterateSkipLimit(){
        var infiniteStream = Stream.iterate(2, i -> i * 3);
        infiniteStream.skip(1).limit(5).toList().forEach(System.out::println);
    }
    private static void streamSortedCompareByName(EmployeeDB employeeDB){
        employeeDB.employeeList.stream().sorted((e1, e2)-> e1.getName().compareTo(e2.getName()))
                .toList().forEach(System.out::println);
    }
    private static void streamSimpleMinById(EmployeeDB employeeDB){
        System.out.println(employeeDB.employeeList.stream().min((e1, e2) -> e1.getId() - e2.getId())
                        .orElseThrow(NoSuchElementException::new));
    }
    private static void streamMaxUsingComparatorBySalary(EmployeeDB employeeDB){
        System.out.println(employeeDB.employeeList.stream().max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new));
    }
    private static void streamComparatorNaturalAndReverseOrder(){
        var numberList = Arrays.asList(1,2,5,2,7,3,5);
        numberList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println();
        numberList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }
    private static void streamDistinct(){
        var numberList = Arrays.asList(1,2,5,2,7,3,5);
        numberList.stream().distinct().toList().forEach(System.out::println);
    }
    private static void streamAllMatchAnyNone(){
        var numberList = Arrays.asList(1,2,5,2,7,3,5);
        var allEven = numberList.stream().allMatch(integer -> integer % 2 == 0);
        var anyEven = numberList.stream().anyMatch(integer -> integer % 2 == 0);
        var noneMultipleOfThree = numberList.stream().noneMatch(integer -> integer % 3 == 0);
        System.out.println(allEven + " " + anyEven + " " + noneMultipleOfThree);
    }
    private static void streamMaxValue(EmployeeDB employeeDB){
        var latestEmployeeId = employeeDB.employeeList.stream().mapToInt(Employee::getId).max();
        latestEmployeeId.ifPresent(i -> System.out.println(latestEmployeeId.getAsInt()));
    }
    private static void streamCreation(){
        var intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(System.out::print);
        System.out.println();
        var rangeIntStream = IntStream.range(1, 4);
        rangeIntStream.forEach(System.out::print);
        System.out.println();
        var streamInteger = Stream.of(1, 2, 3, 4, 5, 6, 7);
        streamInteger.forEach(System.out::print);
    }

    private static void streamAverageAndSum(EmployeeDB employeeDB){
        var average = employeeDB.employeeList.stream().mapToDouble(Employee::getSalary)
                .average().orElseThrow(NoSuchElementException::new);
        System.out.println(average);
        var sum = employeeDB.employeeList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);
    }
    private static void streamReduce(EmployeeDB employeeDB){
        var reduce = employeeDB.employeeList.stream().map(Employee::getSalary).reduce(0d, Double::sum);
        System.out.println(reduce);
    }
    private static void streamJoin(EmployeeDB employeeDB){
        var join = employeeDB.employeeList.stream().map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(join);
    }
    private static void streamToSet(){
        var numberList = Arrays.asList(1,2,5,2,7,3,5);
        var numberSet = new HashSet<>(numberList);
        numberSet.forEach(System.out::println);
    }
    private static void streamToVectorCollection(EmployeeDB employeeDB){
        var vectorCollection = employeeDB.employeeList.stream()
                .map(Employee::getName).collect(Collectors.toCollection(Vector::new));
        vectorCollection.forEach(System.out::println);
    }
    private static void streamSummarizingDouble(EmployeeDB employeeDB){
        var summarizingStatistics = employeeDB.employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Sum: " + summarizingStatistics.getSum());
        System.out.println("Average: " + summarizingStatistics.getAverage());
        System.out.println("Min: " + summarizingStatistics.getMin());
        System.out.println("Max: " + summarizingStatistics.getMax());
        System.out.println("Count: " + summarizingStatistics.getCount());
    }
    private static void streamSummarizingDoubleUsingMap(EmployeeDB employeeDB){
        var summarizingStatistics = employeeDB.employeeList.stream()
                .mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println("Sum: " + summarizingStatistics.getSum());
        System.out.println("Average: " + summarizingStatistics.getAverage());
        System.out.println("Min: " + summarizingStatistics.getMin());
        System.out.println("Max: " + summarizingStatistics.getMax());
        System.out.println("Count: " + summarizingStatistics.getCount());
    }
    private static void streamPartitionBy(){
        var numberList = Arrays.asList(2, 4, 5, 6, 8);
        var isEven = numberList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(isEven.size());
        isEven.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamPartitionBy(EmployeeDB employeeDB){
        var salary = employeeDB.employeeList.stream().collect(
                Collectors.partitioningBy(employee -> employee.getName().equals("Kyle")));
        System.out.println(salary.size());
        salary.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGroupBy(){
        var numberList = Arrays.asList(2, 4, 5, 6, 8);
        var isEven = numberList.stream().collect(
                Collectors.groupingBy(i -> i % 2 == 0));
        System.out.println(isEven.size());
        isEven.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGroupBy(EmployeeDB employeeDB){
        var groupByCharacter = employeeDB.employeeList.stream().collect(
                Collectors.groupingBy(employee -> employee.getName().charAt(0)));
        System.out.println(groupByCharacter.size());
        groupByCharacter.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamMapping(EmployeeDB employeeDB){
        var mapping = employeeDB.employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)
                        ,Collectors.mapping(Employee::getId, Collectors.toList())));
        mapping.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamReducing(EmployeeDB employeeDB){
        var percentage = 10d;
        var reducing = employeeDB.employeeList.stream()
                .map(employee -> employee.getSalary() * percentage / 100).reduce(0d, Double::sum);
        System.out.println(reducing);
    }
    private static void streamReducingAndGroupBy(EmployeeDB employeeDB){
        var namesComparator = Comparator.comparing(Employee::getName);
        var groupEmployeeByMaxNameLength = employeeDB.employeeList.stream().
                collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)
                        ,Collectors.reducing(BinaryOperator.maxBy(namesComparator))));
        groupEmployeeByMaxNameLength.forEach((key, value) -> System.out.println(key + " " + value));
    }
    private static void streamGenerateAndIterate(){
        var generateNumberList = Stream.generate(Math::random).limit(5);
        generateNumberList.forEach(System.out::println);
        System.out.println();
        var infiniteIterator = Stream.iterate(1, i-> i <= 5, i-> i + 1);
        var numberList = infiniteIterator.toList();
        numberList.forEach(System.out::println);
    }
    private static void streamWriteFile(){
        String[] words = {
                "hello",
                "refer",
                "world",
                "level"
        };
        try {
            var uri = Paths.get("src/resources/doc/stream_file.txt");
            var printWriter = new PrintWriter(Files.newBufferedWriter(uri));
            Stream.of(words).forEach(printWriter::println);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamWriteFileEmployee(EmployeeDB employeeDB){
        try {
            var uri = Paths.get("src/resources/doc/stream_file_employee.txt");
            var printWriter = new PrintWriter(Files.newBufferedWriter(uri));
            Stream.of(employeeDB.employeeList.toArray()).forEach(printWriter::println);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamReadFile(){
        try {
            var uri = Paths.get("src/resources/doc/stream_file.txt");
            var words = Files.lines(uri).toList();
            words.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamReadFileEmployee(){
      var employeeList = new ArrayList<>();
        try {
            var uri = Paths.get("src/resources/doc/stream_file_employee.txt");
            var stringEmployeeList = Files.lines(uri).toList();
            stringEmployeeList.forEach(s -> {
                var data = Arrays.stream(s.substring(9, s.length() - 1).split(",")).toList();
                var id = Integer.parseInt(data.get(0).split("=")[1]);
                var name = data.get(1).split("=")[1].replace("'","");
                var salary = Double.parseDouble(data.get(2).split("=")[1]);
                employeeList.add(new Employee(id, name, salary));
            });
            employeeList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void streamTakeWhile(){
        var numberList = Stream.of(1, 2, 1, 4, 2, 6);
        numberList.takeWhile(n -> n < 3).forEach(System.out::println);
    }
    private static void streamDropWhile(){
        var numberList = Stream.of(1, 2, 1, 4, 2, 6);
        numberList.dropWhile(n -> n < 3).forEach(System.out::println);
    }
}
 class EmployeeDB {
    List<Employee> employeeList;
    public EmployeeDB (){
        initEmployeeList();
    }
     private void initEmployeeList(){
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Kyle", 10000d));
        employeeList.add(new Employee(2, "Ros", 20000d));
        employeeList.add(new Employee(3, "Kle", 30000d));
    }
    public Employee findById(Integer id){
        return employeeList.stream().filter(employee ->
                Objects.equals(employee.getId(), id)).findFirst().orElse(null);
    }
}
class Employee {
    private Integer id;
    private String name;
    private Double salary;
    public Employee() {}
    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}