var mapConfig = 
{
    "mapTileLayer":"OSM_MERCATOR",
    "format":"PNG",
    "coordSys":
    {
    "srid":3785,
    "type":"PROJECTED",
    "distConvFactor":1.0,
    "minX":-2.0037508E7,"minY":-2.0037508E7,
    "maxX":2.0037508E7,"maxY":2.0037508E7
    },
    "zoomLevels":
    [
    {"zoomLevel":0,"name":"","tileWidth":4.00750166855785E7,"tileHeight":4.00750166855785E7,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":1,"name":"","tileWidth":2.0037508E7,"tileHeight":2.0037508E7,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":2,"name":"","tileWidth":1.0018754E7,"tileHeight":1.0018754E7,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":3,"name":"","tileWidth":5009377.0,"tileHeight":5009377.0,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":4,"name":"","tileWidth":2504688.5,"tileHeight":2504688.5,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":5,"name":"","tileWidth":1252344.25,"tileHeight":1252344.25,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":6,"name":"","tileWidth":626172.125,"tileHeight":626172.125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":7,"name":"","tileWidth":313086.0625,"tileHeight":313086.0625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":8,"name":"","tileWidth":156543.03125,"tileHeight":156543.03125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":9,"name":"","tileWidth":78271.515625,"tileHeight":78271.515625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":10,"name":"","tileWidth":39135.7578125,"tileHeight":39135.7578125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":11,"name":"","tileWidth":19567.87890625,"tileHeight":19567.87890625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":12,"name":"","tileWidth":9783.939453125,"tileHeight":9783.939453125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":13,"name":"","tileWidth":4891.9697265625,"tileHeight":4891.9697265625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":14,"name":"","tileWidth":2445.98486328125,"tileHeight":2445.98486328125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":15,"name":"","tileWidth":1222.992431640625,"tileHeight":1222.992431640625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":16,"name":"","tileWidth":611.4962158203125,"tileHeight":611.4962158203125,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":17,"name":"","tileWidth":305.74810791015625,"tileHeight":305.74810791015625,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":18,"name":"","tileWidth":152.87405395507812,"tileHeight":152.87405395507812,"tileImageWidth":256,"tileImageHeight":256},
    {"zoomLevel":19,"name":"","tileWidth":76.43702697753906,"tileHeight":76.43702697753906,"tileImageWidth":256,"tileImageHeight":256}
    ]
};

var osmBasemap = new MVCustomMapTileLayer(mapConfig, getOSMMapTileURL);

//Change to your mapviewer instance e.g. localhost:8888/mapviewer/fsmc/jslib/oraclemaps.js 
var baseURL = "http://192.168.106.67:7001/mapviewer" ;    
var mapview;
var oraTheme = null ;
var oraTileLayer = null;

            
    
function showMap(valTorgCode=null, valDate=null) 
{ 
    
    
        
    var trackQuery=  "select  sdo_cs.transform(A.geoloc,'USE_SPHERICAL', 3785) location, A.torg_code code  " + 
                    "FROM mastak.gps_tracks A where A.torg_code = " + (valTorgCode == null ? 2421: valTorgCode) +
                    " and A.oper_date = "+(valDate == null ? "(SYSDATE - 2)" : "to_char(TO_DATE('"+valDate+"','yyyy-MM-dd'), 'dd.mm.yyyy')");
        
    var trackPointsQuery=  "select  sdo_cs.transform(A.geoloc,'USE_SPHERICAL', 3785) location, TO_CHAR(A.oper_time, 'HH24:MI:SS') time " + 
                    " FROM mastak.gps_track_points A where A.torg_code = " + (valTorgCode == null ? 2421: valTorgCode) +
                    " and A.oper_date = "+(valDate == null ? "(SYSDATE - 2)" : "to_char(TO_DATE('"+valDate+"','yyyy-MM-dd'), 'dd.mm.yyyy')");

   
 
 
      
    var mapview = new MVMapView(document.getElementById("map"), baseURL);      
    var basemap = new MVCustomMapTileLayer(mapConfig, getOSMMapTileURL);
    mapview.addMapTileLayer(basemap);                 
    mapview.addMapTileLayer(new MVMapTileLayer("pivtorg.TL_GPS_DEPS_3785"));
    
    
    var theme = '<themes><theme name="JDBC_THEME_INTERS" >' +
    '<jdbc_query ' + 
    'datasource="pivtorg" '+
    'jdbc_srid="3785" ' +
    'spatial_column="location" '+
    'asis="true" ' +   
    'render_style="MDSYS:L.TRANSPARENT">' + trackQuery +
    '</jdbc_query></theme></themes>' ;    
    
    buffertheme = new MVThemeBasedFOI('GPS_TRACKS',theme);
    mapview.addThemeBasedFOI(buffertheme);   
    buffertheme.setBoundingTheme(true,false);
    
     var theme = '<themes><theme name="JDBC_THEME_POINTS" >' +
    '<jdbc_query ' + 
    'datasource="pivtorg" '+
    'jdbc_srid="3785" ' +
    'spatial_column="location" '+
    'label_column="time" ' +
    'asis="true" ' +     
    'render_style="">' + trackPointsQuery +
    '</jdbc_query></theme></themes>' ;    
    
    buffertheme = new MVThemeBasedFOI('GPS_TRACK_POINTS',theme);
    mapview.addThemeBasedFOI(buffertheme);

    
      
    //torg code showing 
    var titleBar =
    '<div style="background-color:transparent; color:red;">'+
    '<h3>' + (valTorgCode == null ? 2421: valTorgCode) + '<h3>' + 
    '</div>';
    md = new MVMapDecoration(titleBar, 0, 0) ;
    mapview.addMapDecoration(md);
    md.setOffset(20, 20) ;
  
    mapview.setCenter(MVSdoGeometry.createPoint(4358544.379,6744423.464,3857));       
    mapview.setZoomLevel(11);
    // Add a navigation panel on the right side of the map
    mapview.addNavigationPanel('east');
    // Add a scale bar
    mapview.addScaleBar();
    
    MVMapView.enableCodingHints(false);
    mapview.display();
    
    
  
}

function getOSMMapTileURL(tx, ty, tw, th, level)
{
    var x = (tx-mapConfig.coordSys.minX)/mapConfig.zoomLevels[level].tileWidth ;
    var y = (mapConfig.coordSys.maxY-ty)/mapConfig.zoomLevels[level].tileHeight-1 ;                 
    return "http://tile.openstreetmap.org/"+(level)+"/"+x+"/"+y+".png";                   
}
  
 function onPageLoad(evt) {                      
    showMap();
 }                