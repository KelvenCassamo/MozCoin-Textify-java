package mz.mozcoin.textify;

import java.util.*;

public class Config {
    protected HashMap<String, Object> mapa;
    private boolean autoDot = true;
    private int language;
    public static final String Err_Negative = "err_negativo";

    public Config() {
        mapa = new HashMap<>();
        mapa.put("currencySymbol", "MT");
        mapa.put("decimalSeparator", ".");
        mapa.put("unit", "Metical");
        mapa.put("subunit", "Centavo");
        mapa.put("unitsingular", "metical");
        mapa.put("unitplural", "meticais");
        mapa.put("subunitsingular", "centavo");
        mapa.put("subunitplural", "centavos");
        mapa.put("conjuncao", "e");
        mapa.put("conjuncaoSymbol", "&");
        mapa.put("err_negativo", "e");

    }

    public HashMap<String, Object> getConfig() {
        return this.mapa;
    }

    public void setAutoDot(boolean b) {
        this.autoDot = b;
    }

    public void setDefaultLanguage(int lang) {
        this.language = lang;
    }

    public void setCustomError(String type, String message) {
        mapa.put(type, message);

    }

    // Métodos Setter
    public void setCurrencySymbol(String currencySymbol) {
        mapa.put("currencySymbol", currencySymbol);
    }

    public void setDecimalSeparator(String decimalSeparator) {
        mapa.put("decimalSeparator", decimalSeparator);
    }

    public void setUnit(String unit) {
        mapa.put("unit", unit);
    }

    public void setSubunit(String subunit) {
        mapa.put("subunit", subunit);
    }

    public void setUnitsingular(String unitsingular) {
        mapa.put("unitsingular", unitsingular);
    }

    public void setUnitplural(String unitplural) {
        mapa.put("unitplural", unitplural);
    }

    public void setSubunitsingular(String subunitsingular) {
        mapa.put("subunitsingular", subunitsingular);
    }

    public void setSubunitplural(String subunitplural) {
        mapa.put("subunitplural", subunitplural);
    }

    public void setConjuncao(String conjuncao) {
        mapa.put("conjuncao", conjuncao);
    }

    public void setConjuncaoSymbol(String conjuncaoSymbol) {
        mapa.put("conjuncaoSymbol", conjuncaoSymbol);
    }

    // Métodos Getter
    public String getCurrencySymbol() {
        return mapa.get("currencySymbol").toString();
    }

    public String getDecimalSeparator() {
        return mapa.get("decimalSeparator").toString();
    }

    public String getUnit() {
        return mapa.get("unit").toString();
    }

    public String getSubunit() {
        return mapa.get("subunit").toString();
    }

    public String getUnitsingular() {
        return mapa.get("unitsingular").toString();
    }

    public String getUnitplural() {
        return mapa.get("unitplural").toString();
    }

    public String getSubunitsingular() {
        return mapa.get("subunitsingular").toString();
    }

    public String getSubunitplural() {
        return mapa.get("subunitplural").toString();
    }

    public String getConjuncao() {
        return mapa.get("conjuncao").toString();
    }

    public String getConjuncaoSymbol() {
        return mapa.get("conjuncaoSymbol").toString();
    }

    public boolean isAutoDotEnabled() {
        return this.autoDot;
    }

    public int getDefaultLanguage() {
        return this.language;
    }

    public String getError(String type) {
        return mapa.get(type).toString();
    }

    /*
     * #
     * ## ## ######## ######### ######### ########## ### # #
     * # # # # # # # # # # ### # # #
     * # # # # # # # # # # ### # # #
     * # # # # # # # # # ### # # #
     * # # # # # # # # ### # # #
     * # # # # # # # # ### # # #
     * # # ######## ######### ########## ########## ### # #
     * 
     */
}
