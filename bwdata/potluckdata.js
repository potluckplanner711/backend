const potluckData =
[
    {
        potluckId: 2,
        potluckTitle: "Title",
        potluckDate: "1/1/2021",
        potluckAddress: "555 W St",
        potluckCity: "Town",
        potluckSt: "St",
        potluckZip: "55555",
        attendees: 
        [
            {
                firstName: "First",
                lastName: "Last",
                type: "ORGANIZER",
                going: true
            },
            {
                firstName: "Mr",
                lastName: "Sir",
                type: "GUEST",
                going: true,
                item: "Salad"
            },
            {
                firstName: "Ms",
                lastName: "Sir",
                type: "GUEST",
                going: true,
                item: "Hotdogs"
            },
            {
                firstName: "Bobby",
                lastName: "Sir",
                type: "GUEST",
                going: true
            }
        ],
        items: 
        [
            {
                itemId: 3,
                itemTitle: "Salad",
                taken: true
            },
            {
                itemId: 4,
                itemTitle: "Hotdogs",
                taken: true
            },
            {
                itemId: 5,
                itemTitle: "Mac and Cheese",
                taken: false
            }
        ]
    },
]