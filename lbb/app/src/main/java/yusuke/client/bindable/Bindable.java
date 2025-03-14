package yusuke.client.bindable;

public interface Bindable {
    int getKey();
    void setKey(int key);

    void onKey();
}
