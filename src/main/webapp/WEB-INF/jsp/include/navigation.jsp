<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">

    <div class="row" id="bottomNav">
        <div class="col-xs-3 col-sm-4 text-center">
            <a href="<c:url value='/'/>"><i class="glyphicon glyphicon-list-alt"></i><br><small>Übersicht</small></a>
        </div>
        <div class="col-xs-3 col-sm-4 text-center">
            <a href="<c:url value='/myscore' />"><span class="badge" id ="score"></span><br><small>Punkte</small></a>
        </div>
        <div class="col-xs-3 col-sm-4 text-center">
            <a href="<c:url value='/teilnahme'/>"><i class="glyphicon glyphicon-info-sign"></i><br><small>Regeln</small></a>
        </div>
        <div class="col-xs-3 visible-xs-block text-center">
            <a href="#" data-toggle="collapse" data-target="#navbar-footer" aria-expanded="false" aria-controls="navbar">
                <i class="glyphicon glyphicon-option-vertical"></i><br><small>Mehr</small>
            </a>
        </div>
    </div>

    <div id="navbar-footer" class="collapse navbar-collapse"  width="100%">
        
        <ul class="nav navbar-nav row" width="100%">
            <li class="col-xs-6 col-sm-2 text-center"><a href="<c:url value='/team'/>" >Das&nbsp;Team</a> </li>
            <li class="col-xs-6 col-sm-2 text-center"><a href="<c:url value='/sponsoren'/>">Sponsoren</a></li>
            <li class="col-xs-6 col-sm-2 text-center"><a href="<c:url value='/impressum'/>" >Impressum</a> </li>
            <li class="col-xs-6 col-sm-2 text-center"><a href="<c:url value='/datenschutz'/>" >Datenschutz</a> </li>  
            <li class="col-xs-6 col-sm-1 text-center">
                <a href="https://www.instagram.com/r750explorer" target="_blank"><i class="fa fa-instagram" aria-hidden="true" style="font-size: 1.5em"></i></a>
            </li>
            <li class="col-xs-6 col-sm-1 text-center">
                <a href="https://www.facebook.com/R750Explorer-133230133892290/" target="_blank"><i class="fa fa-facebook-official" aria-hidden="true" style="font-size: 1.5em"></i></a>
            </li>
        </ul>
    </div>

</div>
</nav> 

<script type="text/javascript">

</script>
