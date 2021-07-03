public class produkt {
    private produkttyp type;
    private produkttyp art;
    private produkttyp bes;
    public produkt(produkttyp typ,produkttyp e1,produkttyp e2){
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
                    }
                    type = produkttyp.Stein;
                    break;
                default:
                    throw new WrongTypeException("Eigenschaft");
            }
        } catch (WrongTypeException wt) {
            System.out.println("Die Definition des Produktes hatte die falsche "+wt.art_f);
            art = null;
            type = null;
            bes = null;
        }
    }
s

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
