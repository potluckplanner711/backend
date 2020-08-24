const userData = 
[
    {
        userId: 1,
        firstName: "First",
        lastName: "Last",
        email: "email@email.com",
        password: "password",
        role: ["ADMIN", "USER"],
        potlucks: 
        [
            {
                potluckId: 2,
                putluckTitle: "Title",
                putluckDate: "1/1/2021",
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
                ],
            }
        ],
        claimedItems: [],
        attendingPotlucks: 
        [
            {
                potluckId: 2,
                putluckTitle: "Title",
                putluckData: "1/1/2020",
                potluckAddress: "555 W St",
                potluckCity: "Town",
                potluckSt: "St",
                potluckZip: "55555",
            },
        ]
    },
    {
        userId: 6,
        firstName: "Mr",
        lastName: "Sir",
        email: "mr@sir.com",
        password: "password",
        role: ["ADMIN", "USER"],
        potlucks: [],
        claimedItems: 
        [
            {
                itemId: 3,
                itemTitle: "Salad"
            }
        ],
        atttendingPotlucks:
        [
            {
                potluckId: 2,
                putluckTitle: "Title",
                putluckData: "1/1/2020",
                potluckAddress: "555 W St",
                potluckCity: "Town",
                potluckSt: "St",
                potluckZip: "55555",
            }
        ]
    },
]