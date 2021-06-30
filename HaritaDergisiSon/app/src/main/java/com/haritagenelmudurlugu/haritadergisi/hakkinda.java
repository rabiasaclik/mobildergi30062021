package com.haritagenelmudurlugu.haritadergisi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class hakkinda extends AppCompatActivity {

    TextView paragraf1,paragraf2,paragraf3,paragraf4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hakkinda);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

       // paragraf1.setText(Html.fromHtml("<p></p>"));
        paragraf1=(TextView) findViewById(R.id.paragraf1);
        paragraf1.setText(Html.fromHtml("<p><b> a. Amaç ve Kapsam </b><br>     Harita Dergisi, Haritacılık bilim ve tekniğiyle ilgili konularda, Harita Genel Müdürlüğü çalışanları ile üniversite öğretim elemanlarının ve konularında uzman meslek bireylerinin makalelerini yayımlayarak literatüre katkı sağlamayı, ayrıca dünya ve ülkemizdeki bilimsel gelişmelerin ilgililere duyurulmasını amaçlamaktadır.<br> Haritacılık ana bilim dalları (jeodezi ve jeofizik, fotogrametri ve uzaktan algılama, coğrafi bilgi sistemleri, kartografya, kamu ölçmeleri) ve haritacılık ile ilgili diğer disiplinlerde (yerbilimleri, uzay teknolojileri, temel bilimler vb.) olmak üzere; bir araştırma çalışmasını bulgu ve sonuçlarıyla yansıtan orijinal bilimsel makaleler, yeterli sayıda bilimsel makaleyi tarayarak, konuyu bugünkü bilgi düzeyinde özetleyen, değerlendiren, bulguları karşılaştırarak eleştiren bilimsel derleme yazılar, orijinalliği ve bilimsel değeri bakımından çok önemli yabancı dilden çeviri bilimsel makaleler Harita Dergisi’nde yayımlanabilir.</p>"));

        paragraf2=(TextView) findViewById(R.id.paragraf2);
        paragraf2.setText(Html.fromHtml("<br><p><b> b. Genel İlkeler </b><br> (1) Harita dergisi Harita Genel Müdürlüğü tarafından 29 Ekim 1933 tarihinden itibaren yılda iki kez (Ocak-Temmuz), basılı ve online yayımlanan, üniversite kütüphanelerinden erişilebilir olan, ulusal hakemli bilimsel bir dergidir.<br> (2) Harita Dergisinde yazılar Türkçe veya İngilizce olarak yayımlanabilmektedir.<br>  (3) Harita Dergisi’nin editörü ve beş değişik üniversitenin öğretim üyelerinden oluşmuş Bilim Kurulu bulunmakta ve bilimsel özgün araştırma makaleleri için iki hakemin olumlu görüşü alınmaktadır.<br>  (4) Dergide çift taraflı kör hakemlik uygulanmaktadır.<br> (5) Dergide yayımlanacak makalelerin incelenmesi için, en az doktora derecesinde akademik unvana sahip hakemler görevlendirilmekte, yayımlanacak makale sayısında kota bulunmamakta ve hakemler tarafından incelenmesi tamamlanan makaleler derginin sıradaki ilk sayısında yayımlanmaktadır.<br> (6) Yayımlanan yazılardaki fikirler yazarlarına aittir. Harita Genel Müdürlüğünü ve dergiyi sorumlu kılmaz. Dergideki yazı ve resimlerin her hakkı saklıdır.</p>"));

        paragraf3=(TextView) findViewById(R.id.paragraf3);
        paragraf3.setText(Html.fromHtml("<br><p> Harita Dergisi ayrıca; <br> (1) Bilimsel ve teknik konularda hazırlanmış ancak hacmi ve özelliği nedeniyle makale şeklinde yayımlanamayan yazılar, bilimsel konferanslar, teknik raporlar, haritacılık yönünden önemli olaylarla ilgili yazılar da olması halinde, Ocak ve Temmuz aylarına ilave özel sayılar şeklinde de yayımlanmakta,<br> (2) TÜBİTAK-ULAKBİM Mühendislik ve Temel Bilimler Veri Tabanında taranmaktadır.</p>"));

        paragraf4=(TextView) findViewById(R.id.paragraf4);
        paragraf4.setText(Html.fromHtml("<br><p><b> c. Etik İlkeler </b><br> Harita Dergisi, gönderilen bilimsel yazılarda Yayın Etiği Kurulu COPE (Committee on Publication Ethics)’un Editör ve Yazarlar için Uluslararası Standartları ile ICMJE (International Committee of Medical Journal Editors) tavsiyeleri dikkate almaktadır.<br> Harita Dergisi’ne online erişim ücretsiz olup, yayımlanmasıyla birlikte web sayfasından erişilebilir. Ayrıca Harita Dergisi basılı olarak belli miktarlarda ilgili yerlere (Bölümün bulunduğu Üniversite Kütüphanelerine, Yüksekokullara vb.) ücretsiz dağıtılmaktadır. Yayımlanacak makaleler için telif ve işlenme ücreti ödenmemektedir.<br></p>"));

    }
}
