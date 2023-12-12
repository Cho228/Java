package Lab0.src.test.java.lab0;

import Lab0.src.main.java.lab0.Variant2;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Variant2Test {

    @Test(expectedExceptions = AssertionError.class)
    public void testInteger2Exc() {
        Variant2.Integer2(999);
    }

    @Test
    public void testInteger2() {
        int expected = 2;
        int actual = Variant2.Integer2(2666);
        assertEquals(actual, expected);
    }

    @Test
    public void testBoolean2() {
        boolean expected = false;
        boolean actual = Variant2.Boolean2(6);
        assertEquals(actual, expected);
    }

    @Test
    public void testIf2_1() {
        int expected = -2;
        int actual = Variant2.If2(0);
        assertEquals(actual, expected);
    }

    @Test
    public void testIf2_2() {
        int expected = 2;
        int actual = Variant2.If2(1);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCase2Exc1() {
        Variant2.Case2(999);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCase2Exc2() {
        Variant2.Case2(0);
    }

    @Test
    public void testCase2_1() {
        String expected = "Bad";
        String actual = Variant2.Case2(1);
        assertEquals(actual, expected);
    }
    @Test
    public void testCase2_2() {
        String expected = "Unsatisfactory";
        String actual = Variant2.Case2(2);
        assertEquals(actual, expected);
    }
    @Test
    public void testCase2_3() {
        String expected = "Satisfactory";
        String actual = Variant2.Case2(3);
        assertEquals(actual, expected);
    }
    @Test
    public void testCase2_4() {
        String expected = "Good";
        String actual = Variant2.Case2(4);
        assertEquals(actual, expected);
    }
    @Test
    public void testCase2_5() {
        String expected = "Awesome";
        String actual = Variant2.Case2(5);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFor2Exc1() {
        Variant2.For2(14, 14);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testFor2Exc2() {
        Variant2.For2(14, 13);
    }

    @Test
    public void testFor2() {
        int expected = 3;
        int actual = Variant2.For2(1,3);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testWhile2Exc1() {
        Variant2.While2(0, 2);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testWhile2Exc2() {
        Variant2.While2(2, 0);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testWhile2Exc3() {
        Variant2.While2(1, 3);
    }

    @Test
    public void testWhile2() {
        int expected = 3;
        int actual = Variant2.While2(6,2);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testArray2Exc() {
        Variant2.Array2(0);
    }

    @Test
    public void testArray2() {
        int[] expected = {2, 4, 8, 16};
        int[] actual = Variant2.Array2(4);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testMatrix2Exc1() {
        Variant2.Matrix2(0, 2);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testMatrix2Exc2() {
        Variant2.Matrix2(3, 0);
    }


    @Test
    public void testMatrix2() {
        int[][] expected = {
                {5, 10, 15, 20},
                {5, 10, 15, 20},
                {5, 10, 15, 20}
        };

        int[][] actual = Variant2.Matrix2(3, 4);
        assertEquals(actual, expected);
    }
}
