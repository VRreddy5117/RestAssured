package JSONReadingHTTPMethods;

public class Requestbody {
private long altitude;
private long latitude;
private long longitude;
private String name;
private long external_id;

public Requestbody() {
   }

    public Requestbody(long altitude, long latitude, long longitude, String name, long external_id) {
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.external_id = external_id;
    }

   /* public Requestbody(String name, long altitude, long latitude, long longitude, String external_id) {
    }*/



    public Requestbody(int external_id) {
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExternal_id() {
        return external_id;
    }

    public void setExternal_id(long external_id) {
        this.external_id = external_id;
    }

    @Override
    public String toString() {
        return "{" +
                "altitude=" + altitude +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", external_id='" + external_id + '\'' +
                '}';
    }
}
