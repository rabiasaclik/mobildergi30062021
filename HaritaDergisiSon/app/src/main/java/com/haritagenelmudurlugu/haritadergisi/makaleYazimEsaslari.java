package com.haritagenelmudurlugu.haritadergisi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class makaleYazimEsaslari extends AppCompatActivity {
TextView paragraf1,paragraf2,indirme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makaleyazimesaslari);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        indirme=(TextView) findViewById(R.id.indirme);
        indirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indirme = new Intent(Intent.ACTION_VIEW);
                indirme.setDataAndType(Uri.parse("https://www.harita.gov.tr/uploads/files-folder/makale_yazim_sablonu.pdf"), "text/html");
                startActivity(indirme);
            }
        });
        // paragraf1=(TextView) findViewById(R.id.paragraf1);
        // paragraf1.setText(Html.fromHtml("<p>Haritacılık bilim dalları (jeodezi, fotogrametri, kartografya, astronomi, jeofizik, kamu ölçmeleri ve mühendislik ölçmeleri) ile ilgili alanlarda olmak üzere, orijinal bir araştırma çalışmasını bulgu ve sonuçlarıyla yansıtan orijinal bilimsel makaleler; yeterli sayıda bilimsel makaleyi tarayarak, konuyu bugünkü bilgi düzeyinde özetleyen, bir değerlendirme yapan, bulguları karşılaştırarak eleştiren bilimsel derleme yazılar; orijinalliği ve bilimsel değeri bakımından çok önemli yabancı dilden çeviri bilimsel makaleler Harita Dergisinde yayımlanabilir.<br><br>Makalesini yayımlanmak üzere gönderen yazarlar, aynı veya benzer bir şekilde başka bir yerde yayımlanmadığını ve telif hakkını devrettiğini belirten “Telif Hakkı Devri Formu”nu doldurarak doğrudan Yönetim Kuruluna gönderebilirler. Yazılar posta veya internet aracılığı ile de gönderilebilir. Gönderilen yazılar kâğıt çıktı olmasının yanı sıra mutlaka sayısal formda olmalıdır.</p><p>Harita Dergisinde yayımlanmak üzere gönderilen yazılar, değerlendirme ve seçme işlemine esas olmak üzere, Yönetim Kurulu adına Yönetim Kurulu Başkanınca belirlenen, konularında uzman en az üç Bilim Kurulu Üyesi tarafından incelenir. Yönetim Kurulu Başkanınca uygun bulunması durumunda, makale Bilim Kurulu üyeleri dışında konularında uzman kişilere de inceletilebilir. Bilim Kurulunca “yetersiz” bulunan yazılar, dergide yayımlanmaz.\n" +
        //        "\n" +
        // "Harita Genel Müdürlüğü tarafından yılda iki kez (Ocak-Temmuz) yayımlanan hakemli bir dergidir. Yayımlanan yazılardaki fikirler yazarlarına aittir. Harita Genel Müdürlüğünı ve dergiyi sorumlu kılmaz. Dergideki yazı ve resimlerin her hakkı saklıdır.<br><br></p>"));
        paragraf2=(TextView) findViewById(R.id.paragraf2);
        paragraf2.setText(Html.fromHtml("<p><br><b>1. Harita Dergisine Yazı Hazırlama Esasları</b><br><br>\n" +
                "\n" +
                "<b>a. </b> Sayfa büyüklüğü A4 (210x297 mm) standardında olmalı; her sayfanın sağ kenarından 2 cm diğer kenarlarından 3’er cm boşluk bırakılmalıdır. Yazı toplam 15 sayfayı geçmemelidir. Yazı, bilgisayarda Microsoft Word formatında Arial Türkçe fontu bir satır aralığı ile yazılmalıdır. <br><br>\n" +
                "\n" +
                "<b>b. </b> Makale adı, Türkçe ve İngilizce olarak kelimelerin ilk harfleri büyük olacak şekilde 12 punto büyüklüğünde sayfanın üst ortasına gelecek şekilde yazılmalı ve iki satırı geçmemelidir. Makale adı, makale içeriğini en fazla ölçüde yansıtmalı; makale içeriğinde anlatılan konuların büyük çoğunluğu, makale adı ile doğrudan ilgili olmalıdır. Makale adından sonra bir satır boşluk bırakıp ortalayarak yazar adı ve soyadı koyu (bold) ve 10 punto harf büyüklüğünde yazılmalıdır (Soyadı büyük harflerle). Yazar adının altına ortalayarak adres ve elektronik posta adresi 9 punto harf büyüklüğünde yazılır.<br><br>\n" +
                "\n" +
                "<b>c. </b> Yazı; makalenin başlangıç kısmına yazılmış, tek paragraf Türkçe ve İngilizce olarak 100-250 kelime arası Türkçe “Öz” ile İngilizce “Abstract”, ortalama 5 adet Anahtar Kelime içeren Anahtar Kelimeler ile Key Words (İngilizce anahtar kelimeler), Giriş, Bölümler, Sonuç ve Kaynaklar şeklindeki ana bölümlerden oluşur. Bu bölümlerin tamamı sayfada iki sütün olacak şekilde yazılır. Sütunlar arasında 0,5 cm boşluk bırakılır. Her ana bölüm ve alt bölüm başlığı öncesi ve sonrası bir satır boşluk bırakılır.<br><br> \n" +
                "Öz bölümünde, yapılan çalışma tanıtılarak kullanılan yöntemler ve sonuçlar kısaca belirtilmeli; abstract bölümü, özün doğru ve eksiksiz tercümesini içermelidir. Giriş bölümünde, çalışmanın amacı ve konuyla ilgili diğer çalışmalar anlatılmalıdır. Ara bölümlerde, kullanılan yöntemler ve veriler açıklanmalı; sonuç bölümünde, bulgular başka araştırmacıların bulguları ile karşılaştırılmalı, yazarın yorumu belirtilmeli ve ayrıca bulgulardan çıkan sonuçlar ve varsa öneriler yazılmalıdır.<br><br> \n" +
                "Ana bölüm başlıkları büyük harflerle koyu (bold) olarak ve alt bölümlerin başlıkları kelimelerin ilk harfleri büyük diğerleri küçük ve sadece birinci düzey alt bölümlerin başlıkları koyu (bold) olarak yazılmalıdır. Yazının geri kalan kısmı normal baskıda yazılmalı, italik ya da altı çizgili karakterler kullanılmamalıdır. Öz, Anahtar Kelime, Abstract (ingilizce özet), Key Words (İngilizce anahtar kelimeler) ve kaynaklar ana bölümleri dışındaki ana bölüm başlıkları 1., 2., 3.; alt bölüm başlıkları a., b., c.; (1), (2), (3); (a), (b), (c); (ı), (ıı), (ııı); (aa), (bb), (cc) şeklinde hiyerarşik düzeyde numaralandırılmalı; ardışık düzeylerin numaraları arasındaki dikey fark 0.5 cm olmalıdır. Numaralandırılan bölümlerin başlıkları, numaralarının başlangıç hizasından 0.5 cm içeriden; bir alt satıra devam eden bölüm başlıkları sayfa başından; tüm paragraflar sayfanın 0.5 cm içerisinden başlamalıdır.<br><br>  \n" +
                "\n" +
                "Noktalama ve imlâ için Türk Dil Kurumu tarafından en son yayımlanan İmlâ Kılavuzu ve Türkçe sözlüğüne, Haritacılık ile ilgili Yönetmeliklerde kullanılan deyimlere uyulmalıdır. İfadelerde üçüncü şahıs kullanılmalı; her sembol ilk geçtiği yerde tanımlanmalı; her kısaltma ilk geçtiği yerde parantez içinde yazılmalı (örneğin, Coğrafi Bilgi Sistemi (CBS)); kelime ikiye bölünmemelidir. Noktalama işaretlerinden sonra bir karakter boşluk bırakılmalı; sayfa numaralama yapılmamalıdır.<br><br>  \n" +
                "\n" +
                "<b>ç. </b> Tablo isimleri, tablonun üstüne sol üst köşesinden itibaren yazılmalı (örneğin, Tablo 1. Karesel ortalama hatalar.); şekil isimleri, şeklin altına ortalanarak yazılmalı (örneğin, Şekil 1. CBS tasarımı.); tablo isimlerinden ve şekillerden önce, şekil isimlerinden ve tablolardan sonra bir satır boşluk bırakılmalı; tablolar ve şekiller sayfaya ortalanmalıdır. Tablolar ve şekillerin boyutu tek sütundan büyük olduğu durumlarda, sayfanın tamamına ortalı olarak yazılabilir.<br><br>  \n" +
                "\n" +
                "<b>d. </b> Denklemlere verilen numaralar, kendi hizalarına ve sayfa sağ kenarına çakışacak şekilde parantez içinde (1),(2),(3),… şeklinde yazılmalıdır. Metin içerisindeki denklemlerin kendi aralarında ve metin ile aralarında bir satır boşluk bırakılır.<br><br>  \n" +
                "\n" +
                "<b>e. </b> Makaleler, “MAKALE ÖRNEĞİ”nde sunulan boşluk ve yapılandırmalara uyularak; Şekil, Tablo ve Denklemler tek sütunda olacak ise metin aralarına konularak; iki sütuna yayılan bir bütün halindeki metin bloğundan sonra veya önce sayfanın alt veya üstünde olacak ve okuma akıcılığını bozmayacak şekilde yazılır. <br><br>  \n" +
                "\n" +
                "<b>f. </b> Yazarlar; unvanlarını, görev yaptıkları kurumları, iletişim adreslerini, telefon numaralarını, e-posta adreslerini ve ORCID (Open Researcher ve Contributor ID) numarasını bildirmelidir. https://orcid.org <br><br>  \n" +
                "\n" +
                "<b>g. </b> Öz ve abstract bölümlerinde kaynak atıfı yapılmamalıdır. Metin içinde kaynak gösterme şekilleri aşağıda verilmiştir:<br><br> \n " +
                "\n" +
                "Tek yazarlı çalışmada ilk gönderme ve diğer göndermeler aynı biçimde olacak; gönderme cümle içerisinde yapılıyorsa Ceylan (2018) veya gönderme cümlenin sonunda yapılıyorsa (Ceylan, 2018)\n <br><br> " +
                "İki yazarlı çalışmada ilk gönderme ve diğer göndermeler aynı biçimde olacak; gönderme cümle içerisinde yapılıyorsa Simav ve Türkezer (2019) veya gönderme cümlenin sonunda yapılıyorsa (Simav ve Türkezer, 2019)\n <br><br> " +
                "Üç, dört ve beş yazarlı çalışmalarda ilk göndermede tüm yazarların soyadları Şengün, Yılmaz ve Kurt (2013) ve diğer göndermelerde Şengün ve diğerleri (2013) veya ilk göndermede (Şengün, Yılmaz ve Kurt, 2013) ve diğer göndermelerde (Şengün ve diğerleri, 2013)\n <br><br> " +
                "Altı ve daha fazla yazarlı çalışmalarda ilk ve diğer göndermelerde sadece ilk yazarın soyadı belirtilir. Yıldız ve diğerleri (2014) veya (Yıldız ve diğerleri, 2014) \n <br><br> " +
                "Tüzel yazarlı çalışmalarda ilk göndermede Maden Tetkik ve Arama Genel Müdürlüğü (MTA, 2017) ve diğer göndermelerde MTA (2017) veya ilk göndermede (Maden Tetkik ve Arama Genel Müdürlüğü [MTA], 2017) ve diğer göndermelerde (MTA, 2017) <br><br> \n" +
                "\n" +
                "<b>ğ. </b> Kaynakların hazırlanmasında Amerikan Psikoloji Birliği (American Physchology Association)’nin hazırladığı rehberin altıncı baskısı (Publication Manual of the American Psychological Association, Sixth Edition) kuralları uygulanacaktır. https://www.apastyle.org \n <br><br> " +
                "Kaynaklar ana bölümü başlığı birer aralıklı büyük harflerle koyu (bold) ve sayfa ortalanarak yazılmalıdır. \n <br><br> " +
                "Kaynaklar ilk yazarlarının soyadına göre alfabetik sırada sıralanır. \n <br><br> " +
                "Makale veya bölüm başlığındaki ilk kelimenin ilk harfi ve eğer varsa özel adların ilk harfleri büyük yazılır. \n <br><br> " +
                "İnternet üzerinden ulaşılan ve zaman içerisinde değiştiği düşünülen kaynağın erişim tarihi internet adresi verilmeden önce (Erişim Adresi (19 Mayıs 2018): …) belirtilmelidir. \n <br><br> " +
                "Özellikle faydalanılan elektronik kaynağın varsa doi numarası yoksa erişim adresi kaynağın sonuna eklenmelidir. <br><br>  \n" +
                "\n" +
                "<b>Elektronik Kaynaklar: Talimat, Rehber vb. </b> <br><br> \n" +
                "\n" +
                "INSPIRE. (2014). D2.8.I.1 Data Specification on\n" +
                "Coordinate Reference Systems – Technical\n" +
                "Guidelines (D2.8.I.1_v3.2). Erişim Adresi:\n" +
                "https://inspire.ec.europa.eu/id/document/tg/rs <br><br> \n" +
                "\n" +
                "ISO 19111. (2007). Geographic information -\n" +
                "Spatial referencing by coordinates. Erişim\n" +
                "Adresi:https://www.iso.org/standard/41126.html <br><br> \n" +
                "\n" +
                "Jekeli, C. (2016). Geometric Reference Systems\n" +
                "in Geodesy. Erişim Adresi:\n" +
                "https://kb.osu.edu/bitstream/handle/1811/779\n" +
                "86/Geom_Ref_Sys_Geodesy_2016.pdf?sequ\n" +
                "ence=1&isAllowed=y <br><br> \n" +
                "\n" +
                "EU Official Journal. (2007). Directive 2007/2/EC\n" +
                "of the European Parliament and of the Council\n" +
                "of 14 March 2007: Establishing an\n" +
                "Infrastructure for Spatial Information in the\n" +
                "European Community (INSPIRE), (L 108/1).\n" +
                "Erişim Adresi: https://eur-lex.europa.eu/legalcontent/EN/ALL/?uri=CELEX:32007L0002 <br><br> \n" +
                "<b>Teknik Rapor:  </b> <br><br>  \n" +
                "\n" +
                "Demir, C. (1999). Türkiye Ulusal Düşey Kontrol\n" +
                "Ağı (JEOFNIV-02-1999). Ankara: Harita Genel Komutanlığı.  </b> <br><br>  \n" +
                "<b>Süreli yayın:  </b> <br><br>  \n" +
                "\n" +
                "Geymen, A., Yomralioglu, T. ve Baz, I. (2008).\n" +
                "Developing an urban information system for\n" +
                "local governments. Proceedings of the\n" +
                "Institution of Civil Engineers-Municipal\n" +
                "Engineer: Published for the Institution of Civil\n" +
                "Engineers, 161(3), 163-173. doi:\n" +
                "10.1680/muen.2008.161.3.163 <br><br>  \n" +
                "\n" +
                "Moritz, H. (1988). Geodetic Reference System\n" +
                "1980. Bulletin Géodésique, 62(3), 348-358.\n" +
                "doi:10.1007/bf02520722 <br><br>  \n" +
                "\n" +
                "Zandbergen, P.A. (2008). A Comparison of\n" +
                "address point, parcel and street geocoding\n" +
                "techniques. Computers, Environment and\n" +
                "Urban Systems, 32, 214-232. doi:\n" +
                "10.1016/j.compenvurbsys.2007.11.006 <br><br>  \n" +
                "\n" +
                "<b>Kitap:  </b> <br><br>  \n" +
                "\n" +
                "Torge, W. ve Müller, J. (2012). Geodesy (4.\n" +
                "baskı). Berlin: Walter de Gruyter.<br><br>  \n" +
                "\n" +
                "Vanícek, P. ve Krakiwsky, E. (1986). Geodesy:\n" +
                "The Concepts (2. baskı). Amsterdam:\n" +
                "Elsevier.<br><br>  \n" +
                "\n" +
                "Day, R.A. (2000). Bilimsel bir makale nasıl yazılır\n" +
                "ve yayımlanır? (G. A. Altay, Çev.). Ankara:\n" +
                "TÜBİTAK.<br><br>  \n" +
                "\n" +
                "<b>Sempozyum, Bildiri vb:  </b> <br><br>  \n" +
                "\n" +
                "Kılıç B. ve Gülgen F. (2017, Kasım). A Research\n" +
                "on Standard Address Usage in Turkey.\n" +
                "UCTEA International Geographical\n" +
                "Information Systems Congress 2017, Adana,\n" +
                "Türkiye. <br><br>  \n" +
                "\n" +
                "Bard, G.V. (2007, Ocak). Spelling-error tolerant,\n" +
                "order-independent pass-phrases via the\n" +
                "Damerau-Levenshtein string-edit distance\n" +
                "metric. In Proceedings of the fifth Australasian\n" +
                "symposium on ACSW frontiers, Ballarat,\n" +
                "Avustralya. <br><br>  \n" +
                "\n" +
                "Yakar, M., Doğan, Y. (2017, Nisan). Silifke Aşağı\n" +
                "Dünya Obruğunun İHA Kullanılarak 3B\n" +
                "Modellenmesi. Türkiye Ulusal Fotogrametri ve\n" +
                "Uzaktan Algılama Birliği Teknik Sempozyum,\n" +
                "Afyonkarahisar. <br><br>  \n" +
                "\n" +
                "<b>Tez:  </b> <br><br>  \n" +
                "\n" +
                "Kellison, M.T. (2012). Address points and A\n" +
                "Master address file: Improving efficiency in\n" +
                "the city of Chino (Doktora Tezi). ProQuest\n" +
                "Dissertations and Theses veri tabanından\n" +
                "erişildi. (UMI No. 1532831)<br><br>  \n" +
                "\n" +
                "Gençerk, E. Y. (2016). İnsansız Hava Aracı\n" +
                "Fotogrametrisi Uygulaması İle İnşaat Projesi\n" +
                "İmalat Durumunun Araştırılması\n" +
                "(Yayımlanmamış Yüksek Lisans Tezi). İTÜ,\n" +
                "Fen Bilimleri Enstitüsü, İstanbul.<br><br>  \n" +
                "\n" +
                "<b>2. Makalelerin Gönderilmesi </b> <br><br>  \n" +
                "\n" +
                "Makaleler, “haritadergisi@harita.gov.tr” adresine e-posta ile gönderilir. </p>"));
    }
}