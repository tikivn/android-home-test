# Home Test

Create a simple Android project to display following UI:

 ![](./sample.gif)

## Requirements

### API calls
- Banner API:  
```
curl https://api.tiki.vn/v2/home/banners/v2
```
- Quick link API:  
```
curl https://api.tiki.vn/shopping/v2/widgets/quick_link
```
- Flash Deal API:  
```
curl https://api.tiki.vn/v2/widget/deals/hot
```

Call `Banner API` + `Quick Link API` in parallel , after both of them finish call `Flash Deal API`

### UI
- Render UI in sequential from top to bottom: Banner -> Quick Link -> Flash Deal
- If the API for that block failed, skip the block.  
Ex: Banner ok, Quick Link failed, Flash Deal ok => render: Banner -> Flash Deal
- Display loading

### Good to have
- You can use any framework library in the project (RxJava, Coroutine, LiveData ...). Handle all concurrency in application by just callbacks is a plus.
- Good architecture, easy to read code is a plus.
- You don't need to create the exact UI, just need to focus on API load and render 3 above widget, doing everything is a plus too.

### Submit
- Please upload the project to github and send the project link + your CV to kiet.nguyen@tiki.vn for evaluation.
