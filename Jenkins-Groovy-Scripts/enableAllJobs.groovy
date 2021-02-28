import hudson.model.*


disableChildren(Hudson.instance.items)

def disableChildren(items) {
  for (item in items) {     
	item.disabled=false
	item.save()
	println(item.name)     
  }
}