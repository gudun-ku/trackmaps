package gktarkos.ru.data.pivtorg;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 28 12:06:13 MSK 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TorgAgentImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        DirName,
        TorgCode,
        Telephon,
        TName;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return TorgAgentImpl.AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return TorgAgentImpl.AttributesEnum.firstIndex() + TorgAgentImpl.AttributesEnum
                                                                            .staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = TorgAgentImpl.AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int DIRNAME = AttributesEnum.DirName.index();
    public static final int TORGCODE = AttributesEnum.TorgCode.index();
    public static final int TELEPHON = AttributesEnum.Telephon.index();
    public static final int TNAME = AttributesEnum.TName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TorgAgentImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("gktarkos.ru.data.pivtorg.TorgAgent");
    }

    /**
     * Gets the attribute value for DirName, using the alias name DirName.
     * @return the value of DirName
     */
    public String getDirName() {
        return (String) getAttributeInternal(DIRNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for DirName.
     * @param value value to set the DirName
     */
    public void setDirName(String value) {
        setAttributeInternal(DIRNAME, value);
    }

    /**
     * Gets the attribute value for TorgCode, using the alias name TorgCode.
     * @return the value of TorgCode
     */
    public Long getTorgCode() {
        return (Long) getAttributeInternal(TORGCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for TorgCode.
     * @param value value to set the TorgCode
     */
    public void setTorgCode(Long value) {
        setAttributeInternal(TORGCODE, value);
    }

    /**
     * Gets the attribute value for Telephon, using the alias name Telephon.
     * @return the value of Telephon
     */
    public Long getTelephon() {
        return (Long) getAttributeInternal(TELEPHON);
    }

    /**
     * Sets <code>value</code> as the attribute value for Telephon.
     * @param value value to set the Telephon
     */
    public void setTelephon(Long value) {
        setAttributeInternal(TELEPHON, value);
    }

    /**
     * Gets the attribute value for TName, using the alias name TName.
     * @return the value of TName
     */
    public String getTName() {
        return (String) getAttributeInternal(TNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for TName.
     * @param value value to set the TName
     */
    public void setTName(String value) {
        setAttributeInternal(TNAME, value);
    }

    /**
     * @param torgCode key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Long torgCode) {
        return new Key(new Object[] { torgCode });
    }

}

