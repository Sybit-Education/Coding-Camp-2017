<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<meta name="mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-title" content="R750Explorer" />
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
<meta name="theme-color" content="#1c3f8d">

<!-- You can use Open Graph tags to customize link previews.
   Learn more: https://developers.facebook.com/docs/sharing/webmasters -->
<meta property="og:url"           content="https://r750explorer.me" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="R750Explorer: Entdecke Radolfzell" />
<meta property="og:description"   content="Endecke mit dieser App Radolfzell und gewinne einen Gutschein." />
<meta property="og:image"         content="<c:url value="/resources/images/icon.svg"/>" />

<link rel="dns-prefetch" href="https://code.jquery.com" />
<link rel="dns-prefetch" href="https://csi.gstatic.com" />
<link rel="dns-prefetch" href="https://maps.gstatic.com" />
<link rel="dns-prefetch" href="https://maps.googleapis.com" />
<link rel="dns-prefetch" href="https://dl.airtable.com" />
<link rel="dns-prefetch" href="https://www.google-analytics.com" />

<link rel="icon" type="image/gif" href="<c:url value='/resources/images/favicon.gif' />" />
<link rel="icon" sizes="192x192" href="<c:url value='/resources/images/icon-196.png' />">
<link rel="apple-touch-icon" href="<c:url value='/resources/images/favicon.png' />" />
<link rel="shortcut icon" sizes="16x16" href="<c:url value='/resources/images/icon-16.png' />">
<link rel="shortcut icon" sizes="196x196" href="<c:url value='/resources/images/icon-196.png' />">
<link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/images/icon-152.png' />">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-horizon.min.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css" />"/>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-3167320-22', 'r750explorer.me');
    ga('set', 'anonymizeIp', true);
    ga('send', 'pageview');

    var contextPath = "${pageContext.request.contextPath}"; //contextPath of App
</script>
