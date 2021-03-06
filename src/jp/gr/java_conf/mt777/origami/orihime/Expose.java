package jp.gr.java_conf.mt777.origami.orihime;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.Egaki_Syokunin;

import java.awt.*;
import java.util.List;

// this class is used to expose Package-private Fields and Methods, mainly from the class ap
public class Expose {

    private static ap frame;

    public static void setFrame(ap frame) {
        Expose.frame = frame;
    }

    public static String getExplanationFileName() {
        return frame.img_kaisetu_fname;
    }

    public static void setExplanationFileName(String fileName) {
        frame.img_kaisetu_fname = fileName;
    }

    public static void Button_kyoutuu_sagyou() {
        frame.Button_kyoutuu_sagyou();
    }

    public static void setI_mouseDragged_yuukou(int i) {
        frame.i_mouseDragged_yuukou = i;
    }

    public static void setI_mouseReleased_yuukou(int i) {
        frame.i_mouseReleased_yuukou = i;
    }

    public static Egaki_Syokunin getEs1() {
        return frame.es1;
    }

    public static void readImageFromFile3(){
        frame.readImageFromFile3();
    }

    public static void memoAndName2File(Memo memo, String fname) {
        frame.memoAndName2File(memo, fname);
    }

    public static File_keisiki_henkan fileConversion() {
        return frame.file_henkan;
    }

    public static String getFrameTitle0() {
        return frame.frame_title_0;
    }
    public static void setFrameTitle0(String title) {
        frame.frame_title_0 = title;
    }

    public static void setFrameTitle(String title) {
        frame.frame_title = title;
    }

    public static String getFrameTitle() {
        return frame.frame_title;
    }

    public static Memo orihime2cp(Memo memo) {
        return frame.file_henkan.orihime2cp(memo);
    }

    public static Memo orihime2svg(Memo memo) {
        return frame.file_henkan.orihime2svg(memo);
    }

    public static List<?> getOaz() {
        return frame.OAZ;
    }

    public static void draw(Graphics g) {
        frame.es1.oekaki_with_camera(g, frame.i_bun_hyouji,frame.i_cp_hyouji,frame.i_a0_hyouji,frame.i_a1_hyouji,
                frame.fTenkaizuSenhaba,frame.i_orisen_hyougen,frame.f_h_TenkaizuSenhaba,frame.dim.width,frame.dim.height,frame.i_mejirusi_hyouji);
    }
}
