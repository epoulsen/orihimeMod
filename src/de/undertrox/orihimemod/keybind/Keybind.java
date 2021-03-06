package de.undertrox.orihimemod.keybind;

import java.awt.event.KeyEvent;

public class Keybind {

    public static final int BUTTON = 0;
    public static final int CHECKBOX = 1;
    public static final int TOGGLE_TYPE = 2;

    private int componentID;
    private int keyCode;
    private boolean shift;
    private boolean ctrl;
    private boolean alt;
    private int type;
    private boolean ignoreModifiers;

    public Keybind(int type, int componentID, int keyCode, boolean shift, boolean ctrl, boolean alt, boolean ignoreModifiers) {
        this.type = type;
        this.componentID = componentID;
        this.keyCode = keyCode;
        this.shift = shift;
        this.ctrl = ctrl;
        this.alt = alt;
        this.ignoreModifiers = ignoreModifiers;
    }
    public Keybind(int type, int componentID, int keyCode, boolean shift, boolean ctrl, boolean alt) {
        this(type, componentID, keyCode, shift, ctrl, alt, false);
    }

    public Keybind(int type, int componentID, int keyCode) {
        this(type, componentID, keyCode, false, false, false);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(getModifiers());
        b.append(KeyEvent.getKeyText(keyCode));
        return b.toString();
    }

    public Keybind(int type, int componentID, char key, boolean shift, boolean ctrl, boolean alt){
        this(type, componentID, KeyEvent.getExtendedKeyCodeForChar(key), shift, ctrl, alt);
    }

    public int getComponentID() {
        return componentID;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getType() {
        return type;
    }

    public boolean hasShift() {
        return shift;
    }

    public boolean hasCtrl() {
        return ctrl;
    }

    public boolean hasAlt() {
        return alt;
    }

    /**
     *
     * @param event KeyEvent to test
     * @return true, if the event matches the parameters of the keybind
     */
    public boolean matches(KeyEvent event) {
        return this.getKeyCode() == event.getExtendedKeyCode() && modifiersMatch(event.getModifiersEx());
    }

    public String getModifiers() {
        String s = "";
        if (ctrl) s += "CTRL+";
        if(alt) s += "ALT+";
        if(shift) s += "SHIFT+";
        return s;
    }

    public void setIgnoreModifiers(boolean ignoreModifiers) {
        this.ignoreModifiers = ignoreModifiers;
    }

    /**
     * returns true if the modifier mask in the argument matches the modifiers of this keybind
     */
    public boolean modifiersMatch(int modifiers) {
        if (ignoreModifiers) return true;
        int onmask = 0;
        int offmask = 0;
        if (hasAlt()) {
            onmask |= KeyEvent.ALT_DOWN_MASK;
        } else {
            offmask |= KeyEvent.ALT_DOWN_MASK;
        }
        if (hasShift()) {
            onmask |= KeyEvent.SHIFT_DOWN_MASK;
        } else {
            offmask |= KeyEvent.SHIFT_DOWN_MASK;
        }
        if (hasCtrl()) {
            onmask |= KeyEvent.CTRL_DOWN_MASK;
        } else {
            offmask |= KeyEvent.CTRL_DOWN_MASK;
        }
        return (modifiers & (onmask|offmask)) == onmask;
    }

    public String toConfigEntry() {
        String s = getConfigID();
        s += "=";
        s += getModifiers();
        s += "kc" + getKeyCode();
        return s;
    }

    public String getConfigID() {
        String s = "orihimeKeybinds.";
        if (type == BUTTON) {
            s += "button.";
        } else if(type == CHECKBOX) {
            s += "checkbox.";
        }
        s += componentID;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keybind keybind = (Keybind) o;
        return componentID == keybind.componentID &&
                keyCode == keybind.keyCode &&
                shift == keybind.shift &&
                ctrl == keybind.ctrl &&
                alt == keybind.alt &&
                type == keybind.type;
    }
}
