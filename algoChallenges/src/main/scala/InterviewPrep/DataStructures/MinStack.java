/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package InterviewPrep.DataStructures;

import java.util.Stack;

/**
 * Created by archeg on 7/29/2015.
 *  Stack with Function min()
 *  Problem: Define a stack, in which we can get its minimum number with a function min.
 *  In this stack, the time complexity of min(), push() and pop() are all O(1).
 */
public class MinStack {
    public static void main(String[] args){
        Check(new MinStackImpl());
        Check(new MinStackImpl2());
    }

    private static void Check(MinStackImpl stack) {
        stack.push(2);
        assert(stack.peekMin() == 2);
        assert(stack.peek() == 2);
        stack.push(3);
        assert(stack.peekMin() == 2);
        assert(stack.peek() == 3);
        stack.push(1);
        assert(stack.peekMin() == 1);
        assert(stack.peek() == 1);

        assert(stack.pop() == 1);
        assert(stack.peekMin() == 2);
        assert(stack.peek() == 3);

        assert(stack.pop() == 3);
        assert(stack.peekMin() == 2);
        assert(stack.peek() == 2);
    }

    public static class MinStackImpl {
        private Stack<Integer> _stack = new Stack<>();
        private Stack<Integer> _auxStack = new Stack<>();

        public Integer pop(){
            _auxStack.pop();
            return _stack.pop();
        }

        public Integer peek() {
            return _stack.peek();
        }

        public Integer peekMin(){
            return _auxStack.peek();
        }

        public void push(Integer i){
            if (_auxStack.empty()){
                _auxStack.push(i);
            } else {
                _auxStack.push(Math.min(i, peekMin()));
            }
            _stack.push(i);
        }
    }

    public static class MinStackImpl2 extends MinStackImpl {
        private Stack<Integer> _stack = new Stack<>();
        private Integer _min = 0;

        public Integer pop(){
            if (_stack.peek() >= _min) {
                return _stack.pop();
            } else {
                Integer top = _stack.pop();
                Integer value = _min;
                _min = 2 * _min - top;
                return value;
            }
        }

        public Integer peek() {
            return _stack.peek();
        }

        public Integer peekMin(){
            return _min;
        }

        public void push(Integer i){
            if (i >= _min){
                _stack.push(i);
            } else {
                _stack.push(2 * i - _min);
                _min = i;
            }
        }
    }
}
