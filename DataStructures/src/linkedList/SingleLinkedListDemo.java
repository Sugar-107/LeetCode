package linkedList;

/**
 * @author 程文辉
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "起飞1", "芜湖1！");
        HeroNode node2 = new HeroNode(2, "起飞2", "芜湖2！");
        HeroNode node3 = new HeroNode(3, "起飞3", "芜湖3！");
        HeroNode.HEAD.addNode(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node1.listNode();
    }

}


class HeroNode{

    /**
     * 编号
     */
    private int id;

    private String name;

    private String nickName;

    public int getId() {
        return id;
    }

    public HeroNode setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroNode setName(String name) {
        this.name = name;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public HeroNode setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public HeroNode getNext() {
        return next;
    }

    public HeroNode setNext(HeroNode next) {
        this.next = next;
        return this;
    }

    public static HeroNode getHEAD() {
        return HEAD;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    /**
     * 下一个指针
     */
    private HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 头结点
     */
    public final static HeroNode HEAD = new HeroNode(0,"","");

    public void addNode(HeroNode next){
        //辅助遍历指针
        HeroNode tmp = HEAD.next;
        //当前链表为空
        if (tmp==null){
            HEAD.next = next;
            return ;
        }
        while (true){
            //如果遍历到链表的尾部
            if (tmp ==null){
                tmp = next;
                return;
            }
            tmp = tmp.next;
        }

    }

    public void listNode(){
        //辅助遍历指针
        HeroNode tmp = HEAD.next;
        //当前链表为空
        if (tmp==null){
            HEAD.next = next;
            return;
        }
        while (true){
            if (tmp == null){
                return;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }

    }



}

