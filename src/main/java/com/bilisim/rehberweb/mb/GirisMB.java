
package com.bilisim.rehberweb.mb;

import com.bilisim.rehberweb.session.GirisFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "girisMB")
@RequestScoped
public class GirisMB {

    @EJB
    private GirisFacade girisFacade;

    private String kullanici;
    private String sifre;

    public GirisMB() {
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String giris() {
        boolean sonuc = girisFacade.girisKontrol(kullanici, sifre);

        if (sonuc) {
            return "menu.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata", "Kullanici Adi veya Sifre Yanlis"));
            return "";
        }

    }

}
