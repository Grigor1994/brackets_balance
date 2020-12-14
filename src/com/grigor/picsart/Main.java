package com.grigor.picsart;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str = "asasd{ddfd}d(dsd)[dsd5]";

        System.out.println(checkBracketBalance("()[]}"));
        System.out.println(checkBracketBalance("asasd{ddfd}d(dsd)[dsd5]"));
        System.out.println(checkBracketBalance("asasd{ddfd}d(dsd[dsd5]"));
        System.out.println(checkBracketBalance("asasd{ddfd}d(dsd)[dsd5]{}"));
    }

    static boolean checkBracketBalance(String str) {
        List<Character> openSymbols = Arrays.asList('(', '[', '{');
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (openSymbols.contains(symbol)) {
                stack.push(str.charAt(i));
            } else if (hashMap.containsKey(symbol)) {
                if (stack.isEmpty() || stack.pop() != hashMap.get(symbol)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

