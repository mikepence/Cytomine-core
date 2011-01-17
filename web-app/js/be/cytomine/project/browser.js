Ext.namespace('Cytomine');

/**
 * @class Cytomine.Browser
 * @singleton
 */
Cytomine.Browser = {
    /**
     * Retourne l'onglet correspondant au viewer de scan
     * @return {Ext.Panel}
     */
    tab: function(idTab, idScan, tabTitle) {
        return new Ext.Panel({
            id: idTab,
            bodyCssClass: 'overflow-auto',
            iconCls: 'envelope-label',
            title: tabTitle,
            closable:true,
            autoLoad : {url:'/cytomine-web/scan/browse/'+idScan,scripts:true},
            item : [
            /*{
                title:'Project',
                collapsible: true, //make this column collapsable

                //contentEl: 'west', //Get our content from the "west" div
                margins: '5 0 5 5',
                cmargins: '5 5 5 5',
                width: 175,
                minSize: 100, //set the limits for resizing
                maxSize: 250 //set the limits for resizing

            }*/]
        });
    }
};

// Update the contents of a tab if it exists, otherwise create a new one
Cytomine.Browser.openScan = function(idTab, idScan, title) {
    var tab = Cytomine.tabs.getItem(idTab);
    if(tab){
        Cytomine.tabs.remove(tab);
    }
    tab = Cytomine.tabs.add(Cytomine.Browser.tab(idTab, idScan, title)).show();
    Cytomine.tabs.setActiveTab(tab);
}
