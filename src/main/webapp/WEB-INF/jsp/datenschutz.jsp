﻿<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="de">

    <head>
        <meta name="robots" content="noindex, follow" />

        <script>
            // Set to the same value as the web property used on the site
            var gaProperty = 'UA-3167320-22';

            // Disable tracking if the opt-out cookie exists.
            var disableStr = 'ga-disable-' + gaProperty;
            if (document.cookie.indexOf(disableStr + '=true') > -1) {
                window[disableStr] = true;
            }

            // Opt-out function
            function gaOptout() {
                document.cookie = disableStr + '=true; expires=Thu, 31 Dec 2099 23:59:59 UTC; path=/';
                window[disableStr] = true;
            }
        </script>
        <c:import url="include/head.jsp"/>
        <title>Datenschutz | R750Explorer</title>
    </head>


    <body>

        <div class="container"> 

            <div class="page-header">
                <h1>Datenschutz&shy;erklärung</h1>
            </div>

            <p>Wir nehmen den Schutz Ihrer Privatsphäre und Ihrer persönlichen Daten, die Sie uns
                zur Verfügung stellen, sehr ernst. Die Beachtung der Bestimmungen des
                Bundesdatenschutz-Gesetzes ist für uns eine Selbstverständlichkeit. Nachstehend    
                informieren wir Sie darüber, welche Daten wir gegebenenfalls sammeln und wie wir damit umgehen.
            </p>

            <p><b>Welche personenbezogenen Daten werden erhoben und verarbeitet?</b><br>
                Sie können unsere Websites besuchen, ohne dass wir irgendwelche personenbezogenen Daten 
                von Ihnen benötigen. Wir erfahren nur den Namen Ihres Internet Service Providers, die Website, 
                von der Sie uns aus besuchen, und die einzelnen Seiten, die Sie bei uns besuchen. Nur wenn Sie 
                bestimmte Service-Leistungen nutzen, werden persönliche Daten erhoben und verarbeitet.
            </p>

            <p><b>Zu welchen Zwecken erheben und verarbeiten wir personenbezogene Daten?</b><br>

                Da wir ständig bestrebt sind, nicht nur für unsere Kunden sondern auch für uns selbst die 
                Service- Angebote in einem kontinuierlichen Prozess zu verbessern, werden die oben genannten 
                allgemeinen Daten statistisch ausgewertet.

                Sofern Sie Service-Leistungen in Anspruch nehmen, werden in der Regel nur solche Daten erhoben, 
                die wir zur Erbringung der Leistungen benötigen. Soweit wir Sie um weitergehende Daten bitten, 
                handelt es sich um freiwillige Informationen.

                Die Verarbeitung der persönlichen Daten erfolgt ausschließlich zur Erfüllung des nachgefragten 
                Service und zur Wahrung berechtigter eigener Geschäftsinteressen.
            </p>

            <p><b>Werden personenbezogene Daten an Dritte weitergegeben?</b><br>
                Wir werden Ihre persönlichen Daten gegenüber anderen Unternehmen oder Institutionen weder 
                offenlegen, überlassen, verkaufen noch anderweitig vermarkten, sofern nicht Ihre 
                ausdrückliche Einverständniserklärung vorliegt.

                Etwas anderes gilt, wenn wir zu einer Offenlegung und Übermittlung der Daten gesetzlich 
                oder durch gerichtliches Urteil verpflichtet sind.
            </p>


            <p><b>Datensicherheit</b><br>
                Wir haben technische und organisatorische Maßnahmen ergriffen, um die von Ihnen zur 
                Verfügung gestellten personenbezogenen Daten vor Verlust, Zerstörung, Manipulation und 
                unberechtigtem Zugriff zu schützen. Alle unsere Mitarbeiter und an der Datenverarbeitung 
                beteiligten Dritte sind auf das Bundesdatenschutzgesetz und den vertraulichen Umgang mit personenbezogenen Daten verpflichtet.

                Wir behalten uns das Recht vor, diese Erklärung jederzeit zu ändern. Sie begründet kein 
                vertragliches oder sonstiges formales Recht gegenüber oder im Auftrag einer Partei.

                Bei Problemen oder Fragen sollten Sie sich direkt an unseren Datenschutzbeauftragten 
                wenden, der Ihnen gerne weiterhilft.
            </p>


            <p><b>Google Analytics</b><br>
                Diese Website benutzt Google Analytics, einen Webanalysedienst der Google Inc.. Google Analytics verwendet sog. Cookies, Textdateien, 
                die auf Ihrem Computer gespeichert werden und die eine Analyse der Benutzung der Website durch Sie ermöglichen. 
                Die durch das Cookie erzeugten Informationen über Ihre Benutzung dieser Website werden in der Regel an 
                einen Server von Google in den USA übertragen und dort gespeichert. Im Falle der Aktivierung der IP-Anonymisierung 
                auf dieser Website, wird Ihre IP-Adresse von Google jedoch innerhalb von Mitgliedstaaten der Europäischen Union 
                oder in anderen Vertragsstaaten des Abkommens über den Europäischen Wirtschaftsraum zuvor gekürzt. Nur in 
                Ausnahmefällen wird die volle IP-Adresse an einen Server von Google in den USA übertragen und dort gekürzt. 
                Im Auftrag des Betreibers dieser Website wird Google diese Informationen benutzen, um Ihre Nutzung der Website 
                auszuwerten, um Reports über die Websiteaktivitäten zusammenzustellen und um weitere mit der Websitenutzung und der 
                Internetnutzung verbundene Dienstleistungen gegenüber dem Websitebetreiber zu erbringen. Die im Rahmen von Google 
                Analytics von Ihrem Browser übermittelte IP-Adresse wird nicht mit anderen Daten von Google zusammengeführt. 
                Sie können die Speicherung der Cookies durch eine entsprechende Einstellung Ihrer Browser-Software verhindern; 
                wir weisen Sie jedoch darauf hin, dass Sie in diesem Fall gegebenenfalls nicht sämtliche Funktionen dieser Website 
                vollumfänglich werden nutzen können. Sie können darüber hinaus die Erfassung der durch das Cookie erzeugten und auf 
                Ihre Nutzung der Website bezogenen Daten (inkl. Ihrer IP-Adresse) an Google sowie die Verarbeitung dieser Daten durch 
                Google verhindern, indem sie das unter dem folgenden Link verfügbare Browser-Plugin herunterladen und installieren: 
                <a href="https://tools.google.com/dlpage/gaoptout?hl=de">Browser-Plugin herunterladen</a>

            </p>
            <p>
                Sie können die Erfassung durch Google Analytics verhindern, indem Sie auf folgenden Link klicken. Es wird ein 
                Opt-Out-Cookie gesetzt, das die zukünftige Erfassung Ihrer Daten beim Besuch dieser Website verhindert:
                <a onclick="alert('Google Analytics wurde deaktiviert');" href="javascript:gaOptout()" >Google Analytics deaktivieren</a>
            </p>
            <p>
                Nähere Informationen zu Nutzungsbedingungen und Datenschutz finden Sie unter folgenden Links:
                <a href="www.google.com/analytics/terms/de.html">www.google.com/analytics/terms/de.html</a> oder
                <a href="www.google.de/intl/de/policies/">www.google.de/intl/de/policies/</a>
            </p>

        </div> 

        <c:import url="include/footer.jsp"/>
    </body>

</html>