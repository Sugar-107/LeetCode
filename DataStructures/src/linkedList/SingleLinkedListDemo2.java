package linkedList;

/**
 * @author 程文辉
 */
public class SingleLinkedListDemo2 {

}

class  SingleLinkedList{

    private HeroNode2 head = new HeroNode2(0,"","");

    public void addOrder(HeroNode2 heroNode2){
        //列表为空
//        if (head.getNext()==null){
//
//        }
        HeroNode2 tmp = head;
    }

    public void list(){

    }

}

class HeroNode2{
    private int id;
    private String name;
    private String nickName;
    private HeroNode2 next;

    public HeroNode2() {
    }

    public HeroNode2(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public HeroNode2 setNext(HeroNode2 next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
