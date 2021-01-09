package com.axel_stein.stack;

/**
 * Implementation of Dijkstra's two stack algorithm
 * @author Axel Stein
 */
public class DijkstraTwoStack {
    private final ArrayStack<Integer> values;
    private final ArrayStack<Operator> operators;

    public DijkstraTwoStack() {
        values = new ArrayStack<>();
        operators = new ArrayStack<>();
    }

    public void value(Integer value) {
        values.push(value);
    }

    public void operator(Operator operator) {
        operators.push(operator);
    }

    public void leftParen() {}

    /**
     * Pop operator and two values. Push the result of applying that operator
     * to those values onto the stack
     */
    public void rightParen() {
        Operator operator = operators.pop();
        Integer val2 = values.pop();
        Integer val1 = values.pop();
        Integer result = null;
        switch (operator) {
            case ADD -> result = val1 + val2;
            case SUB -> result = val1 - val2;
            case MUL -> result = val1 * val2;
            case DIV -> result = val1 / val2;
        }
        values.push(result);
    }

    public Integer result() {
        return values.pop();
    }

    public enum Operator {
        ADD, SUB, MUL, DIV
    }
}
