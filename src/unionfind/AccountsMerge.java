package unionfind;

import java.util.*;

/**
 * @description:
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * @author: zww
 * @date: 2021/1/18
 * @version: V1.0
 */
public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john00@mail.com");
        accounts.add(account);
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnnybravo@mail.com");
        accounts.add(account1);
        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnsmith@mail.com");
        account2.add( "john_newyork@mail.com");
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        account3.add("Mary");
        account3.add("mary@mail.com");
        accounts.add(account3);

//        List<String> account = new ArrayList<>();
//        account.add("Alex");
//        account.add("Alex5@m.co");
//        account.add("Alex4@m.co");
//        account.add("Alex0@m.co");
//        accounts.add(account);
//        List<String> account1 = new ArrayList<>();
//        account1.add("Ethan");
//        account1.add("Ethan3@m.co");
//        account1.add("Ethan3@m.co");
//        account1.add("Ethan0@m.co");
//        accounts.add(account1);
//        List<String> account2 = new ArrayList<>();
//        account2.add("Kevin");
//        account2.add("Kevin4@m.co");
//        account2.add( "Kevin2@m.co");
//        account2.add( "Kevin2@m.co");
//        accounts.add(account2);
//        List<String> account3 = new ArrayList<>();
//        account3.add("Gabe");
//        account3.add("Gabe0@m.co");
//        account3.add("Gabe3@m.co");
//        account3.add("Gabe2@m.co");
//        accounts.add(account3);
//        List<String> account4 = new ArrayList<>();
//        account4.add("Gabe");
//        account4.add("Gabe3@m.co");
//        account4.add("Gabe4@m.co");
//        account4.add("Gabe2@m.co");
//        accounts.add(account4);

//        List<String> account2 = new ArrayList<>();
//        account2.add("Hanzo");
//        account2.add("Hanzo2@m.co");
//        account2.add("Hanzo3@m.co");
//        accounts.add(account2);
//        List<String> account4 = new ArrayList<>();
//        account4.add("Hanzo");
//        account4.add("Hanzo4@m.co");
//        account4.add("Hanzo5@m.co");
//        accounts.add(account4);
//
//        List<String> account = new ArrayList<>();
//        account.add("Hanzo");
//        account.add("Hanzo0@m.co");
//        account.add("Hanzo1@m.co");
//        accounts.add(account);
//
//        List<String> account3 = new ArrayList<>();
//        account3.add("Hanzo");
//        account3.add("Hanzo3@m.co");
//        account3.add("Hanzo4@m.co");
//        accounts.add(account3);
//        List<String> account5 = new ArrayList<>();
//        account5.add("Hanzo");
//        account5.add("Hanzo7@m.co");
//        account5.add("Hanzo8@m.co");
//        accounts.add(account5);
//        List<String> account1 = new ArrayList<>();
//        account1.add("Hanzo");
//        account1.add("Hanzo1@m.co");
//        account1.add("Hanzo2@m.co");
//        accounts.add(account1);
//
//        List<String> account6 = new ArrayList<>();
//        account6.add("Hanzo");
//        account6.add("Hanzo6@m.co");
//        account6.add("Hanzo7@m.co");
//        accounts.add(account6);
//        List<String> account7 = new ArrayList<>();
//        account7.add("Hanzo");
//        account7.add("Hanzo5@m.co");
//        account7.add("Hanzo6@m.co");
//        accounts.add(account7);

        System.out.println(accountsMerge(accounts));
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer,Integer> p = new HashMap<>();
        Map<String,List<Integer>> index = new HashMap<>();
        int size = accounts.size();
        int[] rank = new int[size];
        for (int i = 0; i < size; i++) {
            p.put(i,i);
            rank[i] = 1;
        }
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            int size1 = account.size();
            for (int j = size1 -1; j > 0; j--) {
                String s = account.get(j);
                if(!index.containsKey(s)){
                    index.put(s,new ArrayList<>());
                }else {
                    account.remove(j);
                }
                index.get(s).add(i);
            }
        }
        for (Map.Entry<String,List<Integer>> entry:index.entrySet()) {
            int size1 = entry.getValue().size();
            for (int i = 1; i < size1; i++) {
                union(entry.getValue().get(i-1),entry.getValue().get(i),p,rank);
            }
        }
        Map<Integer,List<String>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            if(!map.containsKey(find(i,p))){
                map.put(find(i,p),account);
            }else {
                map.get(find(i,p)).addAll(account.subList(1,account.size()));
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<Integer,List<String>> entry:map.entrySet()){
            List<String> list = entry.getValue();
            Collections.sort(list.subList(1,list.size()));
            ret.add(list);
        }
        return ret;

    }
    public static void union(int x,int y,Map<Integer,Integer> parent,int[] rank){
        int rootX = find(x,parent);
        int rootY = find(y,parent);
        if(rootX == rootY){
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        rank[rootX] += rank[rootY];
        parent.put(rootY,rootX);
    }

    public static int find(int x,Map<Integer,Integer> parent){
        if(parent.get(x) != x){
            parent.put(x,find(parent.get(x),parent));
        }
        return parent.get(x);
    }

//    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<Integer,Integer> p = new HashMap<>();
//        Map<String,Integer> index = new HashMap<>();
//        int[] rank = new int[accounts.size()];
//        for (int i = 0; i < accounts.size(); i++) {
//            p.put(i,i);
//            rank[i] = 1;
//        }
//        for (int i = 0; i < accounts.size(); i++) {
//            List<String> account = accounts.get(i);
//            for (int j = account.size() - 1; j > 0; j--) {
//                if(index.containsKey(account.get(j))){
//                    if(index.get(account.get(j)) != i){
//                        union(i,index.get(account.get(j)),p,rank);
//                    }
//                    account.remove(j);
//                } else {
//                    index.put(account.get(j),i);
//                }
//            }
//        }
//        Map<Integer,List<String>> map = new HashMap<>();
//        for (int i = 0; i < accounts.size(); i++) {
//            List<String> account = accounts.get(i);
//            Integer root = find(p.get(i),p);
//            if(!map.containsKey(root)){
//                map.put(root,account);
//            }else {
//                account.remove(0);
//                map.get(root).addAll(account);
//            }
//
//        }
//        List<List<String>> ret = new ArrayList<>();
//        for (Map.Entry<Integer,List<String>> entry:map.entrySet()){
//            List<String> list = entry.getValue();
//            Collections.sort(list.subList(1,list.size()));
//            ret.add(list);
//        }
//        return ret;
//
//    }
//    public static void union(int x,int y,Map<Integer,Integer> parent,int[] rank){
//        int rootX = find(x,parent);
//        int rootY = find(y,parent);
//        if(rootX == rootY){
//            return;
//        }
//        if (rank[rootX] < rank[rootY]) {
//            int temp = rootX;
//            rootX = rootY;
//            rootY = temp;
//        }
//        rank[rootX] += rank[rootY];
//        parent.put(rootY,rootX);
//    }
//
//    public static int find(int x,Map<Integer,Integer> parent){
//        if(parent.get(x) != x){
//            parent.put(x,find(parent.get(x),parent));
//        }
//        return parent.get(x);
//    }
}
