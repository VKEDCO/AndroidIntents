package org.vkedco.mobappdev.godelwikipage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class GodelWikiPageBrowserAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.godel_wiki_page_browser_act_layout);
        Intent myIntent = new Intent(Intent.ACTION_VIEW,
        		Uri.parse(getResources().getString(R.string.kurt_godel_wiki_url)));
        
        this.startActivity(myIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.godel_wiki_page_browser, menu);
        return true;
    }
    
}
