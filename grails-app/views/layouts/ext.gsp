<html>
<head>
  <title><g:layoutTitle default="Grails" /></title>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'ext-3.3.1/adapter/ext/ext-base.js')}" ></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'ext-3.3.1/ext-all-debug.js')}" ></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'openlayers/OpenLayers.js')}" ></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'openlayers/OpenURL.js')}" ></script>
  <link rel="stylesheet" href="${createLinkTo(dir:'js',file:'ext-3.3.1/resources/css/ext-all.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'js',file:'ext-3.3.1/resources/css/xtheme-gray.css')}" />

  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'be/cytomine/layout/layout.js')}" ></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'be/cytomine/project/project.js')}" ></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'be/cytomine/project/browser.js')}" ></script>
  <script type="text/javascript" charset="utf-8">
    Ext.BLANK_IMAGE_URL = "${createLinkTo(dir:'js',file:'ext-3.3.1/resources/images/default/s.gif')}";
  </script>
  <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'loading.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'ext.css')}" />
  <g:layoutHead />

</head>
<body onload="${pageProperty(name:'body.onload')}">
<div id="loading-mask"></div>
<div id="loading">
  <div class="loading-indicator">
    Chargement...
  </div>
</div>
<g:layoutBody />
<div id="footer">
    <div style="float:left; margin-bottom: 10px;margin-left: 10px;color: #CCC">
      <span style="font-weight: bold; font-size : 22px;">Cytomine</span>
    </div>
    <div style="float:right; margin-bottom: 10px;margin-right: 10px;color: #CCC">
        <a href="http://www.cytomine.be/" style="padding:5px">Cytomine Project</a> |
        <a href="http://www.giga.ulg.ac.be/" style="padding:5px">GIGA ULg</a>
    </div>
</div>
</body>
</html>

