package gktarkos.ru.view;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import java.util.HashSet;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TrackPropertiesPivtorg implements Serializable {
    @SuppressWarnings("compatibility:-5249447169784142424")
    private static final long serialVersionUID = 1L;
    
    private Integer torgCode;
    private Date trackDate;
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private transient RichInputText itTorgCode;
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private transient RichButton btnShow;
    @SuppressWarnings("org.adfemg.audits.java.comp-ref")
    private transient RichSelectOneChoice torgValue;
    
    

    public void setTorgCode(Integer torgCode) {
        this.torgCode = torgCode;
    }

    public Integer getTorgCode() {
        return torgCode;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public TrackPropertiesPivtorg() {
        this.torgCode = 2421;
        //this.torgValue.setValue(2421);
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        this.trackDate = cal.getTime();
    }

    public void setItTorgCode(RichInputText itTorgCode) {
        this.itTorgCode = itTorgCode;
    }

    public RichInputText getItTorgCode() {
        return itTorgCode;
    }


    public void setBtnShow(RichButton btnShow) {
        this.btnShow = btnShow;
    }

    public RichButton getBtnShow() {
        return btnShow;
    }

    public void btnClickListener(ActionEvent actionEvent) {
        // Add event code here...
        StringBuilder script = new StringBuilder();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(this.trackDate);
        
        
        script.append("torgCode = "+this.torgCode+";");
        script.append("trackDate = '"+formattedDate+"';");
        script.append("showByTorgCode();");

        renderScript(script.toString());
       
    }
   
    private void renderScript(String script)  {
       FacesContext fctx = FacesContext.getCurrentInstance();
       ExtendedRenderKitService erks = null;
       erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
       erks.addScript(fctx, script);
     }

    public void setTorgValue(RichSelectOneChoice torgValue) {
        this.torgValue = torgValue;
    }

    public RichSelectOneChoice getTorgValue() {
        return torgValue;
    }

    public void soc1ValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //the newValue property of the valueChangeEvent shows an array of Strings 
         //with the selected values. This array is updated with each new selection 
         //or de-select
         Long newVal = (Long) valueChangeEvent.getNewValue();
         this.torgCode = newVal.intValue();
         
    }
    
    
   

}
