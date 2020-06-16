/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Rog
 */
public class MyModelEvent {
    private String whatChanged;
    private Object value ;

    public String getWhatChanged() {
        return whatChanged;
    }

    public Object getValue() {
        return value;
    }

    public MyModelEvent(String whatChanged, Object value) {
        this.whatChanged = whatChanged;
        this.value = value;
    }
    
    
}
