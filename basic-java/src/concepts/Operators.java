package concepts;

/**
 * Init with Operators.
 */
public class Operators {

    // Operators

    // Arithmetic -> +-*/%
    int i1 = 10;
    int i2 = 5;
    // Sum -> 15
    int resultSum = i1 + i2;
    // Diff -> 5
    int resultDiff = i1 - i2;
    // Div -> 2
    float resultDiv = (float)(i1 / i2);
    // Pow -> 100 000
    int resultPow = i1 * i2;
    // Rest -> 0
    int resultRes = i1 % i2;

    // Logical -> && || !
    boolean b1 = false;
    boolean b2 = true;
    private void logical() {
        // &&
        if (b1 == false && b2 == true){
        }
        // ||
        if (b1 == false || b2 == true){
        }
        // !
        if (!b1){
        }
    }
    // Relational -> < > == != <= >=
    private void relational() {
        // < -> false
        if (i1 < i2) {}
        // > -> true
        if (i1 > i2) {}
        // == -> false
        if (i1 == i2) {}
        // != -> true
        if (i1 != i2) {}
        // <= -> false
        if (i1 <= i2) {}
        // >= -> true
        if (i1 >= i2) {}
    }
    // Assignation -> = += -= /= *= %=
    private void assignation() {
        // = -> 20
        i1 = 20;
        // += -> 21
        i1 += 1;
        // -= -> 20
        i1 -= 1;
        // /= -> 10
        i1 /= 2;
        // *= -> 20
        i1 *= 2;
        // %= -> 0
        i1 %= 2;
    }
    // Increment -> ++
    private void increment() {
        // var ++ -> 1
        i1++;
        // ++ var -> 2
        ++i1;
    }
    // Decrement -> ++
    private void decrement() {
        // var -- -> 2
        i1--;
        // -- var -> 1
        --i1;
    }
    // Concatenation -> +
    String s1 = "Hello";
    String s2 = "World";
    // + -> "HelloWorld"
    String resultConcat = s1 + s2;
}
