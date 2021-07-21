import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

public class produkt extends JLabel {
    private produkttyp type;
    private produkttyp art;
    private produkttyp bes;
    private URL path;
    private boolean small;
    public long id;
    public ImageIcon picture;
    private long id_cnt;

    public produkt() {
        super();
        id = -1;
        type = null;
        art = null;
        bes = null;
        path =getClass().getResource("leer.png");
        change_size(false);
        this.setText("-1");
    }

    public produkt(produkttyp typ,produkttyp e1,produkttyp e2){
        id = id_cnt;
        ++id_cnt;
        this.setText(new Long(id).toString());
        set_produkt(typ,e1,e2);
    }
    public void change_size(boolean new_val) {
        small = new_val;
        if(!small) {
            picture = new ImageIcon(path);
            this.setIcon(picture);
            picture.setImage(picture.getImage().getScaledInstance(193,140, Image.SCALE_DEFAULT));
        }else {
            picture.setImage(picture.getImage().getScaledInstance(143,90, Image.SCALE_DEFAULT));
        }
    }

    @Override
    public String toString() {
        return "produkt{" +
                "type=" + type +
                ", art=" + art +
                ", bes=" + bes +
                ", path=" + path +
                ", id=" + id +
                ", id_cnt=" + id_cnt +
                '}';
    }
    public void set_produkt(produkttyp typ, produkttyp e1, produkttyp e2) {
        try {
            switch (typ) {
                case Papier:
                    if (e1 != produkttyp.Gruen && e1!= produkttyp.Weis && e1!= produkttyp.Blau) {
                        throw new WrongTypeException("Farbe");
                    } else if ( e2!=produkttyp.A3 && e2!=produkttyp.A4 && e2!=produkttyp.A5) {
                        throw new WrongTypeException("Größe");
                    } else {
                        art = e1;
                        bes = e2;
                        path = getClass().getResource("Papier/"+art.toString()+"_"+bes.toString()+".png");
                    }
                    type = produkttyp.Papier;
                    break;
                case Holz:
                    if (e1 != produkttyp.Kiefer && e1!= produkttyp.Buche && e1!= produkttyp.Eiche) {
                        throw new WrongTypeException("Holzart");
                    } else if ( e2!=produkttyp.Bretter && e2!=produkttyp.Balken && e2!=produkttyp.Scheit) {
                        throw new WrongTypeException("Holzschnitt");
                    } else {
                        art = e1;
                        bes = e2;
                        path = getClass().getResource("Holz/"+art.toString()+"_"+bes.toString()+".png");
                    }
                    type = produkttyp.Holz;
                    break;
                case Stein:
                    if (e1 != produkttyp.Marmor && e1!= produkttyp.Granit && e1!= produkttyp.Sandstein) {
                        throw new WrongTypeException("Farbe");
                    } else if ( e2!=produkttyp.leicht && e2!=produkttyp.mittel && e2!=produkttyp.schwer) {
                        throw new WrongTypeException("Größe");
                    } else {
                        art = e1;
                        bes = e2;
                        path = getClass().getResource("Stein/"+art.toString()+"_"+bes.toString()+".png");
                    }
                    type = produkttyp.Stein;
                    break;
                default:
                    throw new WrongTypeException("Eigenschaft");
            }
            change_size(false);
        } catch (WrongTypeException wt) {
            System.err.println("Die Definition des Produktes hatte die falsche "+wt.art_f);
            art = null;
            type = null;
            bes = null;
        }
    }


    private static class WrongTypeException extends Exception{
        String art_f;
        public WrongTypeException(String f_art){
            super();
            art_f=f_art;
        }
    }


    public produkttyp getArt() {
        return art;
    }
    public produkttyp getEigen() {
        return bes;
    }
    public produkttyp getType() {
        return type;
    }
}
