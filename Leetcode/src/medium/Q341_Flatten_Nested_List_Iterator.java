package medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import linkedin.NestedListSum;

public class Q341_Flatten_Nested_List_Iterator {
    static class NestedIterator implements Iterator<Integer> {
        private Stack<Integer> stack;

        public NestedIterator(List<NestedListSum.NestedInteger> nestedList) {
            stack = new Stack();
            flatten(nestedList, stack);
        }

        @Override
        public Integer next() {
            return stack.pop();
        }

        @Override
        public boolean hasNext() {
            return stack.isEmpty();
        }

        private void flatten(List<NestedListSum.NestedInteger> nestedList, Stack<Integer> stack) {
            for (NestedListSum.NestedInteger ns : nestedList) {
                if (ns.isInteger()) {
                    stack.push(ns.getInteger());
                } else {
                    flatten(ns.getList(), stack);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
