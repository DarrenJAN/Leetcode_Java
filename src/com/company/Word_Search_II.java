package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Search_II {
    List<String> result = new ArrayList<>();
    int[][] dir = new int[][] {{1,0}, {0,1}, {-1, 0}, {0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words)
        {
            TrieNode head = root;

            for(Character character : word.toCharArray())
            {
                if(head.children.containsKey(character))
                {
                    head = head.children.get(character);
                }else
                {
                    TrieNode char_node = new TrieNode();
                    head.children.put(character, char_node);
                    head = char_node;
                }
            }
            head.path = word;
        }


        int row = board.length;
        int col  = board[0].length;

        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0 ; j< col;j++)
            {
                char cur_char = board[i][j];
                if(root.children.containsKey(cur_char))
                {
                    dfs(board, i, j, root, cur_char);
                }
            }

        }
        return result;
    }

    public void dfs(char[][] board, int row, int col, TrieNode root, char cur_char)
    {
        TrieNode trieNode = root.children.get(board[row][col]);

        if( trieNode.path != null)
        {
            result.add(trieNode.path);
            trieNode.path  = null;
        }

        board[row][col] = '*';
        for(int i= 0;i<4;i++)
        {
            int x = row + dir[i][0];
            int y = col + dir[i][1];

            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length)
                continue;
            if(trieNode.children.containsKey(board[x][y]))
                dfs(board, x,y, trieNode, board[x][y]);
        }

        board[row][col] = cur_char;

    }

}

class TrieNode{
        HashMap<Character, TrieNode> children;
        String  path = "";

        public TrieNode() {
            children = new HashMap<>();
            path = "";
        }

}
