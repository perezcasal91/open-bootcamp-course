package concepts;

public class Operators {

    // Operators

    // Arithmetic -> +-*/%
    int anInt1 = 10;
    int anInt2 = 5;
    // Sum -> 15
    int resultSum = anInt1 + anInt2;
    // Diff -> 5
    int resultDiff = anInt1 - anInt2;
    // Div -> 2
    float resultDiv = (float)(anInt1 / anInt2);
    // Pow -> 100 000
    int resultPow = anInt1 * anInt2;
    // Rest -> 0
    int resultRes = anInt1 % anInt2;

    // Logical -> && || !
    boolean aBoolean1 = false;
    boolean aBoolean2 = true;
    private void Logical(){
        // &&
        if (aBoolean1 == false && aBoolean2 == true){
        }
        // ||
        if (aBoolean1 == false || aBoolean2 == true){
        }
        // !
        if (!aBoolean1){
        }
    }
    // Relational -> < > == != <= >=
    private void Relational(){
        // < -> false
        if (anInt1 < anInt2){
        }
        // > -> true
        if (anInt1 > anInt2){
        }
        // == -> false
        if (anInt1 == anInt2){
        }
        // != -> true
        if (anInt1 != anInt2){
        }
        // <= -> false
        if (anInt1 <= anInt2){
        }
        // >= -> true
        if (anInt1 >= anInt2){
        }
    }
    // Assignation -> = += -= /= *= %=
    private void Assignation(){
        // = -> 20
        anInt1 = 20;
        // += -> 21
        anInt1 += 1;
        // -= -> 20
        anInt1 -= 1;
        // /= -> 10
        anInt1 /= 2;
        // *= -> 20
        anInt1 *= 2;
        // %= -> 0
        anInt1 %= 2;
    }
    // Increment -> ++
    private void Increment(){
        // var ++ -> 1
        anInt1++;
        // ++ var -> 2
        ++anInt1;
    }
    // Decrement -> ++
    private void Decrement(){
        // var -- -> 2
        anInt1 --;
        // -- var -> 1
        --anInt1;
    }
    // Concatenation -> +
    String aString1 = "Hello";
    String aString2 = "World";
    // + -> "HelloWorld"
    String resultConcat = aString1 + aString2;

}
