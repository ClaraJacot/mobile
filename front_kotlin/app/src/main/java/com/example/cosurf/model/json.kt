package com.example.cosurf.model
import kotlinx.serialization.Serializable
@Serializable
val jsonSurf = """
    {
    "records": [{
        "id" : "1",
        "Surf Break": "Reef Break",
        "Photos": "https://dl.airtable.com/ZuXJZ2NnTF40kCdBfTld_thomas-ashlock-64485-unsplash.jpg",
        "Address": "Pipeline, Oahu, Hawaii"
        },
        {
        "id": "2",
        "Surf Break": "Point Break",
        "Photos": "https://dl.airtable.com/e3QoP3cFSyykZJOvWGIy_cesar-couto-477018-unsplash%20(1).jpg",
        "Address": "Supertubes, Jeffreys Bay, South Africa"
        }
    ]
}
"""