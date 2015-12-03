package adityashirole.github.io.materialupclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alelak.materialup.MaterialUp;
import com.alelak.materialup.MaterialUpCallback;
import com.alelak.materialup.models.Post;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MaterialUp.getPosts(MainActivity.this, 1, MaterialUp.SORT.LATEST, new MaterialUpCallback() {
            @Override
            public void onSuccess(List<Post> posts, Response response) {
                for (Post post : posts) {
                    Log.i("POST FETCHED","ID : " + post.getId() + ", Title : " + post.getTitle()
                        + ", PreviewUrl : " + post.getPreview_url() + ", ImageUrl : " + post.getImage_url()
                            + ", Upvotes : " + post.getUpvotes() + " ,Url : " + post.getUrl()
                    );
                }
            }

            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(MainActivity.this,"Error : " + e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
