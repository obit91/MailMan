package testing.ohad_beltzer.com.testing;

/**
 * Created by user on 13/05/2015.
 */
public class Msg {

    String number = null;
    int id;
    String name = null;
    String msg = null;

    public Msg(String number, String name, String msg) {
        this.number = number;
        this.name = name;
        this.msg = msg;
    }

    public Msg() {
        // empty constructor
    }

    protected String getNumber() {
        return this.number;
    }

    protected int getID() {
        return this.id;
    }

    protected String getName() {
        return this.name;
    }

    protected String getMsg() {
        return this.msg;
    }

    protected void setNumber(String number) {
        this.number = number;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setMsg(String msg) {
        this.msg = msg;
    }

    protected void setID(int id) {
        this.id = id;
    }
}
