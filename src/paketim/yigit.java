package paketim;

import java.util.Scanner;

public class yigit {
    int tamsayı;
    yigit ileri;

    public yigit(int tamsayı) {
        this.tamsayı = tamsayı;
        ileri = null;
    }

}

class odv {
    int sayaç;
    yigit üst;

    public odv() {
        this.üst = null;
        this.sayaç = 0;
    }

    boolean dolumu() {
        if (üst == null) return false;
        else return true;
    }

    boolean bosmu() {
        if (üst == null) return true;
        else return false;
    }

    void Push(yigit yeni) {
        sayaç++;
        if (üst == null) {
            üst = yeni;
            üst.ileri = null;
        } else {
            yeni.ileri = üst;
            üst = yeni;
        }
    }

    yigit Pop() {
        yigit tut = üst;
        if (dolumu()) {
            üst = üst.ileri;
        }
        sayaç--;
        return tut;
    }

    void tepe() {
        if (üst != null) {
            System.out.println("TEPE NOKTASI => " + üst.tamsayı);
        } else System.out.println("Yığıt boş olduğu için tepe değeri NULL;");
    }

    void cıkıs() {
        System.exit(0);
    }

    void dagıtma(String islem) {
        if (islem == "?") {
            yazdır();
        } else if (islem == "^") {
            System.out.println(Pop().tamsayı);
        } else if (islem == "+" || islem == "-" || islem == "*" || islem == "/") {
            hesaplama(islem);
        } else if (islem == "!") {
            cıkıs();
        } else {
            Push(new yigit(Integer.valueOf(islem)));
        }
    }

    void yazdır() {
        yigit tmp = üst;
        System.out.print("[ ");
        for (int i = 0; i < sayaç; i++) {
            System.out.print(tmp.tamsayı + " ");
            tmp = tmp.ileri;
        }
        System.out.println("]");
    }

    void hesaplama(String isaret) {
        int değer = 0;
        if (isaret == "+") {
            değer = üst.tamsayı + üst.ileri.tamsayı;
        } else if (isaret == "-") {
            değer = üst.tamsayı - üst.ileri.tamsayı;
        } else if (isaret == "*") {
            değer = üst.tamsayı * üst.ileri.tamsayı;
        } else if (isaret == "/") {
            değer = üst.tamsayı / üst.ileri.tamsayı;
        }
        sayaç--;
        gonder(değer);
    }

    void gonder(int değer) {
        üst = üst.ileri;
        üst.tamsayı = değer;
    }

    public static void main(String[] args) {
        odv ODV = new odv();
        System.out.println("DOLU MU? => " + ODV.dolumu());
        System.out.println("BOŞ MU? => " + ODV.bosmu());
        ODV.dagıtma("?");
        ODV.dagıtma("10");
        ODV.tepe();
        ODV.dagıtma("?");
        ODV.dagıtma("20");
        ODV.tepe();
        ODV.dagıtma("30");
        ODV.tepe();
        System.out.println("DOLU MU? => " + ODV.dolumu());
        System.out.println("BOŞ MU? => " + ODV.bosmu());
        ODV.dagıtma("?");
        ODV.dagıtma("*");
        ODV.dagıtma("?");
        ODV.dagıtma("+");
        ODV.dagıtma("?");
        ODV.dagıtma("^");
        ODV.dagıtma("?");
        ODV.tepe();
        System.out.println("DOLU MU? => " + ODV.dolumu());
        System.out.println("BOŞ MU? => " + ODV.bosmu());
        ODV.dagıtma("!");
    }
}
