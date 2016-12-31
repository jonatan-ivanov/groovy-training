//XML, JSON, BSON, etc.
Map<String, Object> message = new HashMap<>();
Map<String, Object> people = new HashMap<>();
Map<String, Object> holmes = new HashMap<>();
Map<String, Object> address = new HashMap<>();
String street = "Baker Street 221B";

address.put("street", street);
holmes.put("address", address);
people.put("holmes", holmes);
message.put("people", people);

println message

System.out.println(((Map)((Map)((Map)message.get("people")).get("holmes")).get("address")).get("street"));

String str = null;
if (message != null) {
    Map<String, Object> ppl = (Map<String, Object>) message.get("people");
    if (ppl != null) {
        Map<String, Object> hlm = (Map) ppl.get("holmes");
        if (hlm != null) {
            Map<String, Object> addr = (Map) hlm.get("address");
            if (addr != null) {
                str = (String) addr.get("street");
            }
        }
    }
}

System.out.println(str);

println message?.people?.holmes?.address?.street
