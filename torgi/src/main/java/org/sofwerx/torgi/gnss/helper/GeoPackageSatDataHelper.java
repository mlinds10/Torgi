package org.sofwerx.torgi.gnss.helper;

import org.sofwerx.torgi.gnss.Constellation;

public class GeoPackageSatDataHelper {
    private long meassuredTime;
    private long id;
    private int svid;
    private Constellation constellation;
    private double cn0;
    private double agc;

    public int getSvid() {
        return svid;
    }

    public void setSvid(Object svid) {
        this.svid = (int)((long)svid);
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Object constellation) {
        this.constellation = Constellation.valueOf((String) constellation);
    }

    public double getCn0() {
        return cn0;
    }

    public void setCn0(Object cn0) {
        this.cn0 = (double)cn0;
    }

    public double getAgc() {
        return agc;
    }

    public void setAgc(Object agc) {
        this.agc = (double)agc;
    }

    public long getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (long)id;
    }

    public long getMeassuredTime() {
        return meassuredTime;
    }

    public void setMeassuredTime(Object meassuredTime) {
        this.meassuredTime = (long) meassuredTime;
    }
}
