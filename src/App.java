import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import dp.Keyboard2Keys;
import dp.LongestPalindromicSubstring;
import dp.MinimumCostForTickets;
import dp.PalindromePartitioning;
import dp.PartitionSubset;
import dp.stocks.MaximumProfitWithAtMost2Transaction;
import graph.FindChampion;
import graph.MinimumObstacleToRemove;
import graph.NumberOfProvinces;
import graph.ShortestDistanceafterQueries;
import graph.SlidingPuzzle;
import graph.SnakesAndLadders;
import graph.ValidArrangementOfPairs;
import greedy.MaximumDistanceArray;
import hash.Anagrams;
import hash.Contest412_1;
import hash.Contest412_2;
import hash.DetermineifTwoStringsAreClose;
import hash.GroupAnagrams;
import hash.MinWindow;
import hash.PairSum;
import hash.RankTransformArray;
import hash.WordPattern;
import heap.ConstructStringWithoutRepeatLimit;
import heap.MaximumAveragePassRatio;
import heap.MedianInDataStream;
import heap.SortIntegersByPowerValue;

import java.util.stream.Collectors;
import linkedelist.HappyNumber;
import linkedelist.ListNode;
import linkedelist.MergeKSortedList;
import math.*;
import matrix.MatrixMaximumSum;
import twoPointers.*;
import searching.*;
import segment.SegmentTree;
import stack.MaxAndMin;
import string.LongestCommonPrefix;
import string.LongestCommonPrefix1;
import string.MovePiecesToObtainAString;
import string.ReverseWordsInaString;
import string.SumOfDigits;
import tree.BTree;
import tree.GTreeNode;
import tree.LinkedListInBinaryTree;
import tree.PointerToNext;
import tree.SmallestCommonRegion;
import trie.FindMaximumXor;
import trie.LongestWordInDictionary;
import trie.MagicDictionary;
import trie.TopKFrequentWords;
import trie.TrieNode;
import stack.CustomStackIncrement;
import queue.DoubleEndedQueue;
import queue.MovingAverage;
import queue.SlidingWindowMaximum;

public class App {
    public static void main(String[] args) throws Exception {

        // SegmentTree t = new SegmentTree(new int[]{1,3,5,7,9,11});
        // int[][] ans = t.getSegmentTree();
        // for(int i=0;i<ans.length;i++){
        // System.out.println("i-" + i + " left-" + ans[i][0] + " right-" + ans[i][1] +
        // " val-" + ans[i][2]);
        // }
        // System.out.println(t.sumRange(1, 3));
        // System.out.println("------------------------");

        // int [][] pairs = {{1,3},{3,2},{2,1}};
        // ValidArrangementOfPairs v = new ValidArrangementOfPairs();
        // int[][] ans1 = v.validArrangement(pairs);
        // for(int i=0;i<ans1.length;i++){
        // System.out.println(ans1[i][0] + " " + ans1[i][1]);
        // }

        SnakesAndLadders s = new SnakesAndLadders();
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
        System.out.println(s.snakesAndLadders(board));

    }

}
