package jianzhiOffer;

// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理
// 例如输入字符串"I am a student. "，则输出"student. a am I"。


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 学会删除前后空白字符函数trim
// reverse函数在StringBuilder里面有，对于数组没有，但是对于list是有的
// 正则表达式的使用方式
// 字符串的join函数
public class Offer58 {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }
}
