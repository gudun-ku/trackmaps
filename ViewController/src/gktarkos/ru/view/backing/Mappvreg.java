package gktarkos.ru.view.backing;

import java.util.Date;

import gktarkos.ru.view.TrackPropertiesPvreg;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

public class Mappvreg {
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private RichInputText it1;
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private RichButton b1;
    private Integer torg_code;
    private Date track_date;
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private RichInputDate itTrackDate;


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }


    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public String b1_action2() {
        // Add event code here...        
        this.torg_code= Integer.parseInt((String)this.it1.getValue());
        this.track_date= (Date)this.itTrackDate.getValue();
        
        return null;
    }


    public void setTorg_code(Integer torg_code) {
        this.torg_code = torg_code;
    }

    public Integer getTorg_code() {
        return torg_code;
    }

    public void setItTrackDate(RichInputDate itTrackDate) {
        this.itTrackDate = itTrackDate;
    }

    public RichInputDate getItTrackDate() {
        return itTrackDate;
    }

    public void setTrack_date(Date track_date) {
        this.track_date = track_date;
    }

    public Date getTrack_date() {
        return track_date;
    }

}
