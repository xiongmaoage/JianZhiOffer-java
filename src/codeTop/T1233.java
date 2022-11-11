package codeTop;

import java.util.*;

public class T1233 {
    // 语义树，用来存储文件结构
    private static class FileTree {
        String name;
        Map<String, FileTree> children;
        boolean isLeaf;

        FileTree(String name) {
            this.name = name;
            this.children = new HashMap<>();
            isLeaf = false;
        }
    }

    List<String> ans;

    public List<String> removeSubfolders(String[] folder) {
        FileTree fileTree = buildFileTree(folder);
        return generatePathList(fileTree);
    }

    private FileTree buildFileTree(String[] folder) {
        FileTree head = new FileTree("HEAD");
        for (String fileList : folder) {
            String[] filePath = fileList.split("/");
            FileTree node = head;
            boolean isAdd = true;
            for (String file : filePath) {
                if (file.isEmpty()) {
                    continue;
                }
                if (node.children.containsKey(file)) {
                    FileTree fileNode = node.children.get(file);
                    if (fileNode.isLeaf) {
                        isAdd = false;
                        break;
                    } else {
                        node = fileNode;
                    }
                } else {
                    FileTree fileNode = new FileTree(file);
                    node.children.put(file, fileNode);
                    node = fileNode;
                }
            }
            if (isAdd) {
                node.isLeaf = true;
                node.children = new HashMap<>();
            }
        }
        return head;
    }

    private List<String> generatePathList(FileTree fileTree) {
        StringBuilder str = new StringBuilder();
        ans = new ArrayList<>();
        FileTree node = fileTree;
        dfs(fileTree, "");
        return ans;
    }

    private void dfs(FileTree node, String str) {
        String newStr = str + "/" + node.name;
        if (node.name.equals("HEAD")) {
            newStr = "";
        }
        if (node.children.isEmpty()) {
            ans.add(newStr);
            return;
        }
        for (String key : node.children.keySet()) {
            dfs(node.children.get(key), newStr);
        }
    }
}
