Given

interface OperationFunctionalInterface{
    int operation(int a, int b);
}

interface CalculatorInterface{
    int performOperation(OperationFunctionalInterface ofi, int num1, int num2);
    static void helpMessage(int exitCode)
    {
        System.out.println("Usage: <num> <operation> <num>");
        System.exit(exitCode);
    }
}

Write a Calculator class that makes uses of the provided code which accepts command line arguments as specified in the help message. If there is an incorrect number of arguments, your program should exit with an error code of 1. If a number is not valid, error code of 2. If an operator is not valid, error code of 3. 

Your calculator only needs to handle integers. 

Your code should be using lambdas to implement the solution. 
