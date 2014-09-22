package com.bbfeechen.gmail;

import java.util.ArrayList;
import java.util.Stack;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		LinkedList.test(args);
		
//		FixedCapacityStackOfStrings.test(args);
//		FixedCapacityStack.test(args);
//		ResizingArrayStack.test(args);
//		Stack.DijkstraTwoStackEvaluate();
//		StdOut.println("The expression " + (Stack.isParentBalanced() ? "is" : "is not") + " balanced");
//		Queue.Josephus();
		
//		Stack<Integer> s1 = new Stack<Integer>();
//		s1.push(1);
//		s1.push(2);
//		s1.push(3);
//		Stack<Integer> s2 = new Stack<Integer>(s1);
//		StdOut.println(s2.pop() + " " + s2.pop() + " " + s2.pop());
		
//		Selection.test(args);
//		Insertion.test(args);
//		Shell.test(args);
//		Merge.test(args);
//		MergeBU.test(args);		
//		Quick.test(args);
//		Quick3way.test(args);		
//		Heap.test(args);
		
//		MaxPQ.test(args);
//		MinPQ.test(args);
//		IndexMaxPQ.test(args);
//		IndexMinPQ.test(args);
		
//		SequentialSearchST.test(args);
//		BinarySearchST.test(args);
//		ST.test(args);
		
//		BST.test(args);
//		RedBlackBST.test(args);
		
//		SeparateChainingHashST.test(args);
//		LinearProbingHashST.test(args);
		
//		Graph.test(args);
//		AdjMatrixGraph.test(args);
//		BreadthFirstPaths.test(args);
//		DepthFirstSearch.test(args);
//		CC.test(args);
//		Bipartite.test(args);		
//		SymbolGraph.test(args);
//		DegreesOfSeparation.test(args);
		
//		Digraph.test(args);
//		AdjMatrixDigraph.test(args);
//		DirectedDFS.test(args);		
//		DirectedCycle.test(args);
//		DepthFirstOrder.test(args);
//		Topological.test(args);
//		KosarajuSharirSCC.test(args);
//		TransitiveClosure.test(args);
		
//		Edge.test(args);
//		EdgeWeightedGraph.test(args);
//		LazyPrimMST.test(args);
//		PrimMST.test(args);
//		KruskalMST.test(args);
//		DirectedEdge.test(args);
//		EdgeWeightedDigraph.test(args);
//		DijkstraSP.test(args);
//		AcyclicSP.test(args);
//		CPM.test(args);
//		BellmanFordSP.test(args);
//		Arbitrage.test(args);
		
//		LSD.test(args);
//		MSD.test(args);
//		Quick3string.test(args);
		
//		TrieST.test(args);
//		TST.test(args);
		
//		RabinKarp.test(args);
//		KMP.test(args);
//		BoyerMoore.test(args);
		
//		NFA.test(args);
//		GREP.test(args);
		
//		BTree.test(args);
		
		// ---------------Leetcode-------------------
//		String[] tokens = {"18"};
//		evalRPE(tokens);
		
//		ArrayList<String> array = generateParenthesis(4);
//		
//		System.out.println("number of array is " + array.size());
	}
	
	// ---------------Leetcode-------------------	
	public static int evalRPE(String[] tokens) {
		if(tokens == null) {
            return 0;
        }
        
        Stack<Integer> st = new Stack<Integer>();
        int rst = 0, op1 = 0, op2 = 0;
        for(int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                    op2 = st.pop();
                    op1 = st.pop();
                    rst = op1 + op2;
                    st.push(rst);
                    break;
                case "-":
                    op2 = st.pop();
                    op1 = st.pop();
                    rst = op1 - op2;
                    st.push(rst);
                    break;
                case "*":
                    op2 = st.pop();
                    op1 = st.pop();
                    rst = op1 * op2;
                    st.push(rst);
                    break;
                case "/":
                    op2 = st.pop();
                    op1 = st.pop();
                    rst = op1 / op2;
                    st.push(rst);
                    break;
                default:
                    st.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }
        return st.pop();
	}
	
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> rst = new ArrayList<String>();
        if(n <= 0) {
            return rst;
        }
        getPair(rst, "", n, n);
        return rst;
    }
    
	public static void getPair( ArrayList<String> rst , String s, int left, int right) {
		if(left > right || left < 0 || right < 0) {
			return; 	
		}
		if(left == 0 && right == 0) {
			rst.add(s);
			return;
		}

		getPair(rst, s + "(", left - 1, right);
		getPair(rst, s + ")", left, right - 1);
	}
}
