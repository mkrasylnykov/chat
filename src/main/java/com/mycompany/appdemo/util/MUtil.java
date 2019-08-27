/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mkrasilnikov
 */

public class MUtil {
    private static final String [] DFN = {"HH_mm_ss", "HH:mm:ss"};
    
    public static String now(int format) { 
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DFN[format]);
        return sdf.format(cal.getTime());
    }

    public static String bbcode(String text) {
        String html = text;
        
        html = html.replace("<", "&lt;");
        html = html.replace(">", "&gt;");

        Map<String,String> bbMap = new HashMap<String , String>();

        //bbMap.put("(<)", "&lt;"); // Так не прокатит т.к. работает в пределах одного
        //bbMap.put("(>)", "&gt;"); // обработчика и зарубит все последующие скобки
        bbMap.put("(\r\n|\r|\n|\n\r)", "<br/>");
        bbMap.put("\\[(b|B)\\](.+?)\\[/(b|B)\\]", "<strong>$2</strong>");
        bbMap.put("\\[(i|I)\\](.+?)\\[/(i|I)\\]", "<span style='font-style:italic;'>$2</span>");
        bbMap.put("\\[(u|U)\\](.+?)\\[/(u|U)\\]", "<span style='text-decoration:underline;'>$2</span>");
        bbMap.put("\\[(s|S)\\](.+?)\\[/(s|S)\\]", "<strike>$2</strike>");
        bbMap.put("\\[(h1|H1)\\](.+?)\\[/(h1|H1)\\]", "<h1>$2</h1>");
        bbMap.put("\\[(h2|H2)\\](.+?)\\[/(h2|H2)\\]", "<h2>$2</h2>");
        bbMap.put("\\[(h3|H3)\\](.+?)\\[/(h3|H3)\\]", "<h3>$2</h3>");
        bbMap.put("\\[(h4|H4)\\](.+?)\\[/(h4|H4)\\]", "<h4>$2</h4>");
        bbMap.put("\\[(h5|H5)\\](.+?)\\[/(h5|H5)\\]", "<h5>$2</h5>");
        bbMap.put("\\[(h6|H6)\\](.+?)\\[/(h6|H6)\\]", "<h6>$6</h6>");
        bbMap.put("\\[(q|Q)(u|U)(o|O)(t|T)(e|E)\\](.+?)\\[/(q|Q)(u|U)(o|O)(t|T)(e|E)\\]", "<blockquote class=\"quote\">$6</blockquote>");
        bbMap.put("\\[(s|S)(p|P)(o|O)(i|I)(l|L)(e|E)(r|R)\\](.+?)\\[/(s|S)(p|P)(o|O)(i|I)(l|L)(e|E)(r|R)\\]", "<blockspoiler class=\"text_spoiler\">$8</blockspoiler>");
        bbMap.put("\\[(p|P)\\](.+?)\\[/(p|P)\\]", "<p>$2</p>");
        bbMap.put("\\[(p|P)=(.+?),(.+?)\\](.+?)\\[/(p|P)\\]", "<p style='text-indent:$2px;line-height:$3%;'>$4</p>");
        bbMap.put("\\[(c|C)(e|E)(n|N)(t|T)(e|E)(r|R)\\](.+?)\\[/(c|C)(e|E)(n|N)(t|T)(e|E)(r|R)\\]", "<div align='center'>$7</div>");
        bbMap.put("\\[(l|L)(e|E)(f|F)(t|T)\\](.+?)\\[/(l|L)(e|E)(f|F)(t|T)\\]", "<div align='left'>$5</div>");
        bbMap.put("\\[(r|R)(i|I)(g|G)(h|H)(t|T)\\](.+?)\\[/(r|R)(i|I)(g|G)(h|H)(t|T)\\]", "<div align='right'>$6</div>");
        bbMap.put("\\[(j|J)(u|U)(s|S)(t|T)(i|I)(f|F)(y|Y)\\](.+?)\\[/(j|J)(u|U)(s|S)(t|T)(i|I)(f|F)(y|Y)\\]", "<div align='justify'>$8</div>");
        bbMap.put("\\[(a|A)(l|L)(i|I)(g|Q)(n|N)=(.+?)\\](.+?)\\[/(a|A)(l|L)(i|I)(g|Q)(n|N)\\]", "<div align='$6'>$7</div>");
        bbMap.put("\\[(c|C)(o|O)(l|L)(o|O)(r|R)=(.+?)\\](.+?)\\[/(c|C)(o|O)(l|L)(o|O)(r|R)\\]", "<span style='color:$6;'>$7</span>");
        bbMap.put("\\[(s|S)(i|I)(z|Z)(e|E)=(.+?)\\](.+?)\\[/(s|S)(i|I)(z|Z)(e|E)\\]", "<span style='font-size:$5;'>$6</span>");
        bbMap.put("\\[(i|I)(m|M)(g|G)\\](.+?)\\[/(i|I)(m|M)(g|G)\\]", "<img src='$4' />");
        bbMap.put("\\[(i|I)(m|M)(g|G)=(.+?),(.+?)\\](.+?)\\[/(i|I)(m|M)(g|G)\\]", "<img width='$4' height='$5' src='$6' />");
        bbMap.put("\\[(e|E)(m|M)(a|A)(i|I)(l|L)\\](.+?)\\[/(e|E)(m|M)(a|A)(i|I)(l|L)\\]", "<a href='mailto:$6'>$6</a>");
        bbMap.put("\\[(e|E)(m|M)(a|A)(i|I)(l|L)=(.+?)\\](.+?)\\[/(e|E)(m|M)(a|A)(i|I)(l|L)\\]", "<a href='mailto:$6'>$7</a>");
        bbMap.put("\\[(u|U)(r|R)(l|L)\\](.+?)\\[/(u|U)(r|R)(l|L)\\]", "<a href='$4'>$4</a>");
        bbMap.put("\\[(u|U)(r|R)(l|L)=(.+?)\\](.+?)\\[/(u|U)(r|R)(l|L)\\]", "<a href='$4'>$5</a>");
        bbMap.put("\\[(y|Y)(o|O)(u|U)(t|T)(u|U)(b|B)(e|E)\\](.+?)\\[/(y|Y)(o|O)(u|U)(t|T)(u|U)(b|B)(e|E)\\]", "<object width='512' height='304'><param name='movie' value='http://www.youtube.com/v/$8'></param><embed src='http://www.youtube.com/v/$8' type='application/x-shockwave-flash' width='512' height='304'></embed></object>");
        bbMap.put("\\[(v|V)(i|I)(d|D)(e|E)(o|O)\\](.+?)\\[/(v|V)(i|I)(d|D)(e|E)(o|O)\\]", "<video src='$6' />");

        bbMap.put(":(w|W)(i|I)(n|N)(k|K):", "<img style=\"vertical-align: middle;border: none;\" alt=\"wink\" src=\"img/smile/wink.gif\" />");
        bbMap.put(":(w|W)(i|I)(n|N)(k|K)(e|E)(d|D):", "<img style=\"vertical-align: middle;border: none;\" alt=\"winked\" src=\"img/smile/winked.gif\" />");
        bbMap.put(":(s|S)(m|M)(i|I)(l|L)(e|E):", "<img style=\"vertical-align: middle;border: none;\" alt=\"smile\" src=\"img/smile/smile.gif\" />");
        bbMap.put(":(a|A)(m|M):", "<img style=\"vertical-align: middle;border: none;\" alt=\"am\" src=\"img/smile/am.gif\" />");
        bbMap.put(":(b|B)(e|E)(l|L)(a|A)(y|Y):", "<img style=\"vertical-align: middle;border: none;\" alt=\"belay\" src=\"img/smile/belay.gif\" />");
        bbMap.put(":(f|F)(e|E)(e|E)(l|L):", "<img style=\"vertical-align: middle;border: none;\" alt=\"feel\" src=\"img/smile/feel.gif\" />");
        bbMap.put(":(f|F)(e|E)(l|L)(l|L)(o|O)(w|W):", "<img style=\"vertical-align: middle;border: none;\" alt=\"fellow\" src=\"img/smile/fellow.gif\" />");
        bbMap.put(":(l|L)(a|A)(u|U)(g|G)(h|H)(i|I)(n|N)(g|G):", "<img style=\"vertical-align: middle;border: none;\" alt=\"laughing\" src=\"img/smile/laughing.gif\" />");
        bbMap.put(":(l|L)(o|O)(l|L):", "<img style=\"vertical-align: middle;border: none;\" alt=\"lol\" src=\"img/smile/lol.gif\" />");
        bbMap.put(":(l|L)(o|O)(v|V)(e|E):", "<img style=\"vertical-align: middle;border: none;\" alt=\"love\" src=\"img/smile/love.gif\" />");
        bbMap.put(":(n|N)(o|O):", "<img style=\"vertical-align: middle;border: none;\" alt=\"no\" src=\"img/smile/no.gif\" />");
        bbMap.put(":(r|R)(e|E)(c|C)(o|O)(u|U)(r|R)(s|S)(e|E):", "<img style=\"vertical-align: middle;border: none;\" alt=\"recourse\" src=\"img/smile/recourse.gif\" />");
        bbMap.put(":(r|R)(e|E)(q|Q)(u|U)(e|E)(s|S)(t|T):", "<img style=\"vertical-align: middle;border: none;\" alt=\"request\" src=\"img/smile/request.gif\" />");
        bbMap.put(":(s|S)(a|A)(d|D):", "<img style=\"vertical-align: middle;border: none;\" alt=\"sad\" src=\"img/smile/sad.gif\" />");
        bbMap.put(":(t|T)(o|O)(n|N)(g|G)(u|U)(e|E):", "<img style=\"vertical-align: middle;border: none;\" alt=\"tongue\" src=\"img/smile/tongue.gif\" />");
        bbMap.put(":(w|W)(a|A)(s|S)(s|S)(a|A)(t|T):", "<img style=\"vertical-align: middle;border: none;\" alt=\"wassat\" src=\"img/smile/wassat.gif\" />");
        bbMap.put(":(c|C)(r|R)(y|Y)(i|I)(n|N)(g|G):", "<img style=\"vertical-align: middle;border: none;\" alt=\"crying\" src=\"img/smile/crying.gif\" />");
        bbMap.put(":(w|W)(h|H)(a|A)(t|T):", "<img style=\"vertical-align: middle;border: none;\" alt=\"what\" src=\"img/smile/what.gif\" />");
        bbMap.put(":(b|B)(u|U)(l|L)(l|L)(y|Y):", "<img style=\"vertical-align: middle;border: none;\" alt=\"bully\" src=\"img/smile/bully.gif\" />");
        bbMap.put(":(a|A)(n|N)(g|G)(r|R)(y|Y):", "<img style=\"vertical-align: middle;border: none;\" alt=\"angry\" src=\"img/smile/angry.gif\" />");


        for (Map.Entry entry: bbMap.entrySet()) {
            html = html.replaceAll(entry.getKey().toString(), entry.getValue().toString());
        }

        return html;
    }
}