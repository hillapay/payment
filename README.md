# Hillapay

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](http://hillavas.com/)

This library  best For basic libraries.

  - By HttpURLConnection, AsyncTask and Gson converter
  - Post method
  - Get method
  - Small library

## How to use

#### 1. Add dependencies

##### Add it in your root build.gradle at the end of repositories:
```sh
 allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
```
##### Add the dependency
```sh
 dependencies {
 	        implementation 'com.github.mehrtarh:hillarest:1.0.2'
 	}
```


#### 2. Add api class
```sh
 public class HillaSampleApi extends HillaRestBaseCallApi {


    public HillaSampleApi() {
        super(new HillaRestHttpConnection.Builder()
                .header(new HillaSampleHeadersApi("h1", "h2", "h3"))
                .baseUrl(SampleRestConfig.getBaseUrl())
                .readTimeout(10000)
                .connectionTimeout(15000)
                .addConverter(HillaSampleGsonConverterFactory.create(
                        new HillaGsonBuilder().create()))
                .build());
    }

    public void getPostModel(
            HillaRestCallback<PostSampleModel> callback) {

        SampleBodyModel sampleBodyModel = new SampleBodyModel("b1", "b2");
        List<HillaRestParamModel> paramModels = new ArrayList<>();
        paramModels.add(new HillaRestParamModel("param1", "p1"));
        paramModels.add(new HillaRestParamModel("param2", "p2"));

        post(SampleRestConfig.getPostUrl(), PostSampleModel.class, sampleBodyModel, paramModels, callback);

    }
}
```
#### 3. Add factoryconverter class
```sh
public final class HillaSampleGsonConverterFactory extends HillaBaseGsonConverterFactory {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static HillaBaseGsonConverterFactory create() {
        return create(new HillaGson());
    }
    public static HillaBaseGsonConverterFactory create(HillaGson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new HillaSampleGsonConverterFactory(gson);
    }

    private final HillaGson gson;

    private HillaSampleGsonConverterFactory(HillaGson gson) {
        this.gson = gson;
    }

    @Override
    public <T> void modelToJsonConverter(T model, OutputStream outputStream) throws IOException {

        final HillaJsonWriter writer = new HillaJsonWriter(new OutputStreamWriter(outputStream, UTF_8));
        gson.toJson(model, model.getClass(), writer);
        writer.flush();
        writer.close();

    }

    @Override
    public <T> T jsonToModelConverter(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);

    }
}

```

#### 4. Add header class
```sh
public class HillaSampleHeadersApi extends HillaRestBaseHeader {

    private final String header1;
    private final String header2;
    private final String header3;

    public HillaSampleHeadersApi(String header1, String header2, String header3) {
        this.header1 = header1;
        this.header2 = header2;
        this.header3 = header3;
    }


    @Override
    public List<HillaRestHeaderModel> getHeaders() {
        List<HillaRestHeaderModel> headers = new ArrayList<>();


        headers.add(new HillaRestHeaderModel(
                "header1",
                header1
        ));
        headers.add(new HillaRestHeaderModel(
                "header2",
                header2
        ));
        headers.add(new HillaRestHeaderModel(
                "header3",
                header3
        ));


        return headers;
    }
}

```

#### 4. And Use in project

```sh
HillaSampleApi hillaSampleApi = new HillaSampleApi();

        hillaSampleApi.getPostModel(new HillaRestCallback<PostSampleModel>() {
            @Override
            public void onResponse(HillaRestResponse<PostSampleModel> response) {
                if (response != null && response.code() == 200 && response.body() != null)
                    postSampleModel = response.body();

            }

            @Override
            public void onFailure(Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
```