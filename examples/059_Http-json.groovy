import groovy.json.*
def urlStr = 'https://query.yahooapis.com/v1/public/yql?q=select+item.condition+from+weather.forecast+where+woeid+in+(select+woeid+from+geo.places(1)+where+text="Mountain+View,California,US")&format=json'
def rs = urlStr.toURL().text
def json = new JsonSlurper().parseText(rs)

def condition = json?.query?.results?.channel?.item?.condition
println "Weather in Mountain View, CA: $condition.text, temperature: $condition.temp F"
