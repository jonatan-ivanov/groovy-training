def url= 'http://feeds.feedburner.com/groovyblogs'
def rss = new XmlParser().parse(url)

rss.channel.item.title[0..2]*.text().each { println it }
